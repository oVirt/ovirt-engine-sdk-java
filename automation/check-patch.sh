#!/bin/sh -ex

# Clean and then create the artifacts directory:
rm -rf exported-artifacts
mkdir -p exported-artifacts

# Create a settings file that uses the our artifactory server as proxy
# for all repositories:
settings="$(pwd)/settings.xml"
cat > "${settings}" <<.
<settings>
  <mirrors>

    <mirror>
      <id>ovirt-artifactory</id>
      <url>http://artifactory.ovirt.org/artifactory/ovirt-mirror</url>
      <mirrorOf>*</mirrorOf>
    </mirror>

    <mirror>
      <id>maven-central</id>
      <url>http://repo.maven.apache.org/maven2</url>
      <mirrorOf>*</mirrorOf>
    </mirror>

  </mirrors>
</settings>
.

# There may be several versions of Java installed in the build enviroment, and
# we need to make sure that Java 8 is used, as it is required by the code
# generator:
export JAVA_HOME="$(dirname $(rpm -ql java-1.8.0-openjdk-devel | grep '/bin$'))"

# Calculate the version number:
version="$(python automation/version.py)"

# Build the SDK:
mvn package -s "${settings}"

# Generate the .tar.gz file containing the generated SDK:
tar_name="ovirt-engine-sdk-java"
tar_prefix="${tar_name}-${version}"
tar_file="${PWD}/${tar_prefix}.tar.gz"
tar -czf "${tar_file}" --transform="s|^\.|${tar_prefix}|" -C sdk .

# Build the RPM:
cp "${tar_file}" packaging/.
pushd packaging
  export tar_version="${version}"
  export tar_url="$(basename ${tar_file})"
  export rpm_dist="$(rpm --eval '%dist')"
  export rpm_release="0.0${rpm_dist}"
  ./build.sh
popd

# Copy the RPM files to the exported artifacts directory:
for file in "${tar_file}" $(find packaging -type f -name '*.rpm'); do
  echo "Archiving file \"$file\"."
  mv "$file" exported-artifacts
done
