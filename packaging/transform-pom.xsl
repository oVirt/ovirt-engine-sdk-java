<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:pom="http://maven.apache.org/POM/4.0.0">

  <!-- Replace the parent with the version and groupId: -->
  <xsl:template match="/pom:project/pom:parent">
    <xsl:copy-of select="pom:version"/>
    <xsl:copy-of select="pom:groupId"/>
  </xsl:template>

  <!-- Remove the build section: -->
  <xsl:template match="/pom:project/pom:build"/>

  <!-- Remove test dependencies: -->
  <xsl:template match="/pom:project/pom:dependencies/pom:dependency[pom:scope = 'test']"/>

  <!-- Copy everything else without changes: -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>

