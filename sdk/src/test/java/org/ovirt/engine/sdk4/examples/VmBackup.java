/*
Copyright (c) 2017 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.sdk4.examples;

import static org.ovirt.engine.sdk4.builders.Builders.disk;
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment;
import static org.ovirt.engine.sdk4.builders.Builders.event;
import static org.ovirt.engine.sdk4.builders.Builders.snapshot;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.ConnectionBuilder;
import org.ovirt.engine.sdk4.services.DiskAttachmentService;
import org.ovirt.engine.sdk4.services.DiskAttachmentsService;
import org.ovirt.engine.sdk4.services.EventsService;
import org.ovirt.engine.sdk4.services.SnapshotDisksService;
import org.ovirt.engine.sdk4.services.SnapshotService;
import org.ovirt.engine.sdk4.services.SnapshotsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.LogSeverity;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.SnapshotStatus;
import org.ovirt.engine.sdk4.types.Vm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example shows how the virtual machine backup process.
 */
public class VmBackup {
    // The logger:
    private static final Logger log = LoggerFactory.getLogger(VmBackup.class);

    // The connection details:
    private static final String API_URL = "https://engine40.example.com/ovirt-engine/api";
    private static final String API_USER = "admin@internal";
    private static final String API_PASSWORD = "redhat123";

    // The file containing the certificate of the CA used by the server. In an usual installation it will be in
    // the file '/etc/pki/ovirt-engine/.truststore'.
    private static final String API_TRUSTSTORE = "truststore.jks";

    // The name of the application, to be used as the 'origin' of events sent to the audit log:
    private static final String APPLICATION_NAME = "mybackup";

    // The name of the virtual machine that contains the data that we want to back-up:
    private static final String DATA_VM_NAME = "myvm";

    // The name of the virtual machine where we will attach the disks in order to actually back-up them. This virtual
    // machine will usually have some kind of back-up software installed.
    private static final String AGENT_VM_NAME = "myagent";

    /**
     * Create an instance of the VmBackup class, and run it. This is just to avoid making the rest of the methods
     * static, as that is harder to reuse.
     */
    public static void main(String[] args) throws Exception {
        VmBackup main = new VmBackup();
        main.run();
    }

    /**
     * This is the non-static method equivalent to {@code main}. Its purpose is to create a connection to the server and
     * make sure that it is always closed, regardless of what happens during the execution of the actual work.
     */
    private void run() throws Exception {
        // Connect to the server:
        ConnectionBuilder builder = ConnectionBuilder.connection()
            .url(API_URL)
            .user(API_USER)
            .password(API_PASSWORD)
            .trustStoreFile(API_TRUSTSTORE);

        // Do the rest of the work and always remember to close the connection:
        try (Connection connection = builder.build()) {
            log.info("Connected to the server.");
            run(connection.systemService());
        }
    }

    /**
     * This is the method that performs the actual work.
     *
     * @param systemService the reference to the root of services
     * @throws Exception if something fails while doing the work
     */
    private void run(SystemService systemService) throws Exception {
        // Get the reference to the service that we will use to send events to the audit log:
        EventsService eventsService = systemService.eventsService();

        // In order to send events we need to also send unique integer ids. These should usually come from an external
        // database, but in this example we will just generate them from the current time in seconds since Jan 1st 1970.
        int eventId = (int) (System.currentTimeMillis() / 1000);

        // Get the reference to the service that manages the virtual machines:
        VmsService vmsService = systemService.vmsService();

        // Find the virtual machine that we want to back up. Note that we need to use the 'all_content' parameter to
        // retrieve the retrieve the OVF, as it isn't retrieved by default:
        Vm dataVm = vmsService.list()
            .search(String.format("name=%s", DATA_VM_NAME))
            .allContent(true)
            .send()
            .vms()
            .get(0);
        log.info("Found data virtual machine '{}', the id is '{}'.", dataVm.name(), dataVm.id());

        // Find the virtual machine were we will attach the disks in order to do the backup:
        Vm agentVm = vmsService.list()
            .search(String.format("name=%s", AGENT_VM_NAME))
            .send()
            .vms()
            .get(0);
        log.info("Found agent virtual machine '{}', the id is '{}'.", agentVm.name(), agentVm.id());

        // Find the services that manage the data and agent virtual machines:
        VmService dataVmService = vmsService.vmService(dataVm.id());
        VmService agentVmService = vmsService.vmService(agentVm.id());

        // Create an unique description for the snapshot, so that it is easier for the administrator to identify this
        // snapshot as a temporary one created just for backup purposes:
        String snapDescription = String.format("%s-backup-%s", dataVm.name(), UUID.randomUUID());

        // Send an external event to indicate to the administrator that the backup of the virtual machine is starting.
        // Note that the description of the event contains the name of the virtual machine and the name of the temporary
        // snapshot, this way, if something fails, the administrator will know what snapshot was used and remove it
        // manually.
        eventsService.add()
            .event(
                event()
                    .vm(
                        vm()
                            .id(dataVm.id())
                    )
                    .origin(APPLICATION_NAME)
                    .severity(LogSeverity.NORMAL)
                    .customId(eventId++)
                    .description(String.format(
                        "Backup of virtual machine '%s' using snapshot '%s' is starting.",
                        dataVm.name(),
                        snapDescription
                    ))
            )
            .send();

        // Save the OVF to a file, so that we can use to restore the virtual machine later. The name of the file is the
        // name of the virtual machine, followed by a dash and the identifier of the virtual machine, to make it unique:
        String ovfData = dataVm.initialization().configuration().data();
        File ovfFile = new File(String.format("%s-%s.ovf", dataVm.name(), dataVm.id()));
        try (OutputStream ovfStream = new FileOutputStream(ovfFile)) {
            ovfStream.write(ovfData.getBytes(StandardCharsets.UTF_8));
        }
        log.info("Wrote OVF to file '{}'", ovfFile.getAbsolutePath());

        // Send the request to create the snapshot. Note that this will return before the snapshot is completely
        // created, so we will later need to wait till the snapshot is completely created.
        SnapshotsService snapsService = dataVmService.snapshotsService();
        Snapshot snap = snapsService.add()
            .snapshot(
                snapshot()
                    .description(snapDescription)
            )
            .send()
            .snapshot();
        log.info("Sent request to create snapshot '{}', the id is '{}'.", snap.description(), snap.id());

        // Poll and wait till the status of the snapshot is 'ok', which means that it is completely created:
        SnapshotService snapService = snapsService.snapshotService(snap.id());
        while (snap.snapshotStatus() != SnapshotStatus.OK) {
            log.info("Waiting till the snapshot is created, the status is now '{}'.", snap.snapshotStatus());
            Thread.sleep(1 * 1000);
            snap = snapService.get().send().snapshot();
        }
        log.info("The snapshot is now complete.");

        // Retrieve the descriptions of the disks of the snapshot:
        SnapshotDisksService snapDisksService = snapService.disksService();
        List<Disk> snapDisks = snapDisksService.list().send().disks();

        // Attach all the disks of the snapshot to the agent virtual machine, and save the resulting disk attachments
        // in a list so that we can later detach them easily:
        DiskAttachmentsService attachmentsService = agentVmService.diskAttachmentsService();
        List<DiskAttachment> attachments = new ArrayList<>();
        for (Disk snapDisk : snapDisks) {
            DiskAttachment attachment = attachmentsService.add()
                .attachment(
                    diskAttachment()
                        .disk(
                            disk()
                                .id(snapDisk.id())
                                .snapshot(
                                    snapshot()
                                        .id(snap.id())
                                )
                        )
                        .active(true)
                        .bootable(false)
                        .interface_(DiskInterface.VIRTIO)
                )
                .send()
                .attachment();
            attachments.add(attachment);
            log.info("Attached disk '{}' to the agent virtual machine.", attachment.disk().id());
        }

        // Now the disks are attached to the virtual agent virtual machine, we can then ask that virtual machine to
        // perform the backup. Doing that requires a mechanism to talk to the backup software that runs inside the
        // agent virtual machine. That is outside of the scope of the SDK. But if the guest agent is installed in the
        // virtual machine then we can provide useful information, like the identifiers of the disks that have just
        // been attached.
        for (DiskAttachment attachment : attachments) {
            if (attachment.logicalNamePresent()) {
                log.info("Logical name for disk '{}' is '{}'.", attachment.disk().id(), attachment.logicalName());
            }
            else {
                log.info(
                    "The logical name for disk '{}' isn't available. Is the guest agent installed?",
                    attachment.disk().id()
                );
            }
        }

        // Insert here the code to contact the backup agent and do the actual backup ...
        log.info("Doing the actual backup ...");

        // Detach the disks from the agent virtual machine:
        for (DiskAttachment attachment : attachments) {
            DiskAttachmentService attachmentService = attachmentsService.attachmentService(attachment.id());
            attachmentService.remove().send();
            log.info("Detached disk '{}' to from the agent virtual machine.", attachment.disk().id());
        }

        // Remove the snapshot:
        snapService.remove().send();
        log.info("Removed the snapshot '{}'.", snap.description());

        // Send an external event to indicate to the administrator that the backup of the virtual machine is completed:
        eventsService.add()
            .event(
                event()
                    .vm(
                        vm()
                            .id(dataVm.id())
                    )
                    .origin(APPLICATION_NAME)
                    .severity(LogSeverity.NORMAL)
                    .customId(eventId++)
                    .description(String.format(
                        "Backup of virtual machine '%s' using snapshot '%s' is completed.",
                        dataVm.name(),
                        snapDescription
                    ))
            )
            .send();

        // Bye:
        log.info("Bye!");
    }
}