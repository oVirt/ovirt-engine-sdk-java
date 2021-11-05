.PHONY: installdeps srpm

installdeps:
	dnf -y install ant git httpcomponents-client jackson-annotations jackson-core jackson-databind java-11-openjdk-devel javapackages-local \
		libxslt maven maven-local python3 python3-lxml rpm-build rpmdevtools slf4j

srpm: installdeps
	./automation/build.py
	cp exported-artifacts/*.src.rpm $(outdir)
