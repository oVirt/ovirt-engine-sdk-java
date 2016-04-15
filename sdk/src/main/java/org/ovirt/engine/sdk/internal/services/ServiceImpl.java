package org.ovirt.engine.sdk.internal.services;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk.internal.HttpConnection;
import org.ovirt.engine.sdk.internal.xml.XmlActionReader;
import org.ovirt.engine.sdk.internal.xml.XmlFaultReader;
import org.ovirt.engine.sdk.types.Action;
import org.ovirt.engine.sdk.types.Fault;

import java.io.IOException;

public class ServiceImpl {

    private String path;
    private HttpConnection connection;

    public ServiceImpl() {
        this.connection = null;
        this.path = null;
    }

    public ServiceImpl(HttpConnection connection, String path) {
        this.connection = connection;
        this.path = path;
    }

    public void checkFault(HttpResponse response) {
        Fault fault = null;
        try (XmlReader reader = new XmlReader(response.getEntity().getContent())) {
            fault = XmlFaultReader.readOne(reader);
            if (fault != null) {
                this.throwError(response, fault);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            EntityUtils.consumeQuietly(response.getEntity());
        }
    }

    public Action checkAction(HttpResponse response) {
        try (XmlReader reader = new XmlReader(response.getEntity().getContent())) {
            Action action = XmlActionReader.readOne(reader);
            if (action != null && action.faultPresent()) {
                this.throwError(response, action.fault());
            }
            return action;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            EntityUtils.consumeQuietly(response.getEntity());
        }
    }

    public void throwError(HttpResponse response, Fault fault) {
        StringBuilder buffer = new StringBuilder();
        if (fault.reasonPresent()) {
            if (buffer.length() > 0) {
                buffer.append(" ");
            }
            buffer.append(
                String.format(
                    "Fault reason is \"%s\".",
                    fault.reason()
                )
            );
        }

        if (fault.detailPresent()) {
            if (buffer.length() > 0) {
                buffer.append(" ");
            }
            buffer.append(
                String.format(
                    "Fault detail is \"%s\".",
                    fault.detail())
            );
        }

        if (response != null && response.getStatusLine() != null) {
            if (buffer.length() > 0) {
                buffer.append(" ");
            }
            buffer.append(
                String.format(
                    "HTTP response code is \"%s\".",
                    response.getStatusLine().getStatusCode()
                )
            );
            buffer.append(" ");
            buffer.append(
                String.format(
                    "HTTP response message is \"%s\".",
                    response.getStatusLine().getReasonPhrase()
                )
            );
        }
        throw new RuntimeException(buffer.toString());
    }

    public HttpConnection getConnection() {
        return connection;
    }

    public String getPath() {
        return path;
    }
}
