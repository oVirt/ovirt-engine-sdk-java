oVirt Java SDK
==============

Introduction
------------

The oVirt Java SDK is a Java library that simplfies access to the oVirt
Engine REST API.

Using
-----

If you want to use the Java SDK in your application you will need the
`.jar` file and its dependencies. The Java SDK is available in Maven
central, so the easiest way to get it and its dependencies is to include
a `dependency` element inside your own `pom.xml` file:

    <dependency>
        <groupId>org.ovirt.engine.sdk</groupId>
        <artifactId>ovirt-engine-sdk-java</artifactId>
        <version>3.5.0.5</version>
    </dependency>

If you aren't using Maven to manage your dependencies you will need to
get the dependencies manually and add them to the class path of your
application. Currently the SDK uses the following Java libraries:

- [Apache Commons BeanUtils](http://commons.apache.org/proper/commons-beanutils)
- [Apache Commons Codec](http://commons.apache.org/proper/commons-codec)
- [Apache Commons Logging](http://commons.apache.org/proper/commons-logging)
- [Apache HTTP Components](http://hc.apache.org)
- [Apache log4j 1.2](http://logging.apache.org/log4j/1.2)

Generating
----------

Most of the source code of the Java SDK is automatically generated from the
metadata provided by the oVirt Engine artifacts. The code generator is a Java
program that resides in the `ovirt-engine-sdk-java-codegen` directory. In order
to use it you will need first to build it, using Maven:

    $ cd ../ovirt-engine-sdk-java-codegen
    $ mvn clean install

Then you will need to place the files containing the XML schema of entities and
the RSDL in the `src/main/resources` directory. This can be done manually, but
it is better to extract them from the engine Maven artifacts, running the
following command:

    $ mvn validate -Pupdate-metadata -Dengine.version="3.6.0-SNAPSHOT"

This requires that the Maven artifacts are available either locally or in an
accessible remote Maven repository. As those artifacts aren't currently
published to any public Maven repository this means that you will have to build
the engine first.

The `engine.version` property is used to indicate which version of the metadata
should be extracted. You may have several versions of the engine artifacts
available, so it is important to select the right one. The default value of
this property corresponds to the branch of the SDK that you are using, so
usually you won't need to specify this in the command line, instead of that you
should change the value in the `pom.xml` file.

With the metadata files in place you can update the generate source code as
follows:

    $ mvn validate -Pupdate-code

After doing this make sure to inspect the generated source code (running `git
diff`, for example) to make sure that no backwards compatibility breaking
changes are introduced.

Once you have inspected the code, and if everything looks correct, commit the
modified metadata and source files. The commit message for this change should
include a reference to the commit or tag of the engine that was used to
download the updated metadata. For example:

    sdk: Regenerate against the latest API

    This patch regenerates the SDK using the latest API obtained from
    the engine built from commit fffffff, corresponding to tag
    ovirt-engine-3.5.7.

Releasing
---------

In order to do a new release the first thing to do is to decide what will be
the release number. Curently the release numbers of the Java SDK have four
numbers, separated by dots. The first three numbers correspond to the version
of the engine that was used in the last generation. So if last generation was
for engine 3.5.7 then the version number should be 3.5.7.`x`. The value of `x`
is increased for each release, and reset to 0 when the other three numbers
change.

The `pom.xml` files need to be changed to remove the `-SNAPSHOT` suffix from
the version number.

Once the next release number is decided the `Makefile` *may* need to be changed
to set the RPM release number to `1`.

The `%changelog` in all the `spec.*.in` should be updated so that it contains
short descriptions of bugs fixed and relevant changes.

Look at commit ea06203 (with command, `git show ea06203`) for a typical release
commit.

Don't forget to create tag the release commit, and push it to the upstream repository:

    $ git commit -a -m "Release 3.5.7.0" 3.5.7.0
    $ git push origin 3.5.7.0 HEAD:refs/heads/sdk_3.5

To finish the release you need to do an additional change that prepares for the
next development iteration, basically adding the `-SNAPSHOT` suffix in the
`pom.xml` file. Commit e9b76aa is a good example. Note that this file will
usually already contain the correct next version number, so usually there is no
need to change the version number itself, only add the `-SNAPSHOT` suffix.

Packaging
---------

To create the RPM packages just run `make rpm`:

    $ git branch -D tmp
    $ git checkout -b tmp 3.5.7.0
    $ git clean -dfx
    $ make rpm

The generated `.rpm` file will be available in the `rpmtop/RPMS/noarch`
directory.

Note that there are several `spec.*.in` templates, one for each supported
distribution. Whenever making a packaging change remember to make it in
all the relevant templates.
