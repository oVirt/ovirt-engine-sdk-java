#!/usr/bin/python

import lxml.etree
import os
import re
import sys


def main():
    # Check that the POM file exists:
    pom_path = "sdk/pom.xml"
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

    # Calculate the version number, removing the SNAPSHOT suffix if needed:
    version = re.sub(r"-SNAPSHOT$", "", pom_version)

    # Print the version:
    print(version)

    # Done
    sys.exit(0)


if __name__ == "__main__":
    main()
