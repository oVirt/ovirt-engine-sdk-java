.PHONY: installdeps git_cfg_safe srpm

installdeps:
	dnf -y install ant git httpcomponents-client jackson-annotations jackson-core jackson-databind java-11-openjdk-devel javapackages-local \
		libxslt maven maven-local python3 python3-lxml rpm-build rpmdevtools slf4j

git_cfg_safe:
	# From git 2.35.2 we need to mark temporary directory, where the project is cloned to, as safe, otherwise
	# git commands won't work because of the fix for CVE-2022-24765
	git config --global --add safe.directory "$(shell pwd)"

srpm: installdeps git_cfg_safe
	./automation/build.py
	cp exported-artifacts/*.src.rpm $(outdir)
