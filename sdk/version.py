#!/usr/bin/python

import lxml.etree
import optparse
import os
import re
import sys


def main():
    # Create the command line parser:
    usage = "Usage: %prog [OPTIONS]..."
    parser = optparse.OptionParser(usage)
    parser.description = \
        "A simple tool to extract version numbers from the POM file."

    # Help option:
    help = parser.get_option("--help")
    help.help = "Show this help message and exit."

    # Option to request the POM version:
    parser.add_option(
        "--pom",
        dest="pom",
        action="store_true",
        default=False,
        help=(
            "Extract the version from the POM."
        )
    )

    # Option to request the RPM version:
    parser.add_option(
        "--rpm",
        dest="rpm",
        action="store_true",
        default=False,
        help=(
            "Calculate the RPM version from the POM version, removing the "
            "SNAPSHOT suffix if required."
        )
    )

    # Parse the command line:
    options, args = parser.parse_args()

    # Check that the given options don't conflict (only one of --pom or --rpm
    # can be specified):
    if options.pom and options.rpm:
        parser.print_usage()
        print("Only one of the --pom and --rpm optios is allowed.")
        sys.exit(1)

    # Check that at least one of the required options has been specified:
    if not options.pom and not options.rpm:
        parser.print_usage()
        print("At least one of the --pom or --rpm options must be used.")
        sys.exit(1)

    # Check that the POM file exists:
    pom_path = "pom.xml"
    if not os.path.exists(pom_path):
        print("The POM file \"%s\" doesn't exist." % pom_path)
        sys.exit(1)

    # Parse the POM document:
    try:
        pom_document = lxml.etree.parse(pom_path)
    except lxml.etree.XMLSyntaxError:
        print("Can't parse POM file \"%s\"." % pom_path)
        sys.exit(1)

    # Extract the version number:
    namespaces = {
        "pom": "http://maven.apache.org/POM/4.0.0",
    }
    version_nodes = pom_document.xpath(
        "/pom:project/pom:version",
        namespaces=namespaces
    )
    if not version_nodes:
        print("Can't find version number inside POM file \"%s\"." % pom_path)
        sys.exit(1)
    version_node = version_nodes[0]
    pom_version = version_node.text

    # Calculate the RPM version number, removing the SNAPSHOT suffix if needed:
    rpm_version = re.sub(r"-SNAPSHOT$", "", pom_version)

    # Output the requested data:
    if options.pom:
        print(pom_version)
    elif options.rpm:
        print(rpm_version)

    # Done
    sys.exit(0)


if __name__ == "__main__":
    main()
