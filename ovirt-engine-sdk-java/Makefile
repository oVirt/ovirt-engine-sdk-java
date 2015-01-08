all: rpm

pomversion=$(shell ./version.py --pom)
rpmversion=$(shell ./version.py --rpm)
rpmdist=$(shell rpm --eval '%dist')
rpmrelease=0.5$(rpmsuffix)$(rpmdist)

RPMTOP=$(shell bash -c "pwd -P")/rpmtop
NAME=ovirt-engine-sdk-java
SPEC=$(NAME).spec

TARBALL=$(NAME)-$(pomversion).tar.gz
SRPM=$(RPMTOP)/SRPMS/$(NAME)-$(rpmversion)-$(rpmrelease).src.rpm

$(SPEC): spec$(rpmdist).in
	sed \
		-e 's/@POM_VERSION@/$(pomversion)/g' \
		-e 's/@RPM_VERSION@/$(rpmversion)/g' \
		-e 's/@RPM_RELEASE@/$(rpmrelease)/g' \
		-e 's/@TARBALL@/$(TARBALL)/g' \
		< $< \
		> $@

.PHONY: dist tarball
tarball: dist
dist: $(TARBALL)
$(TARBALL): Makefile $(NAME).spec #$(TESTS)
	git ls-files | tar --transform='s#^#$(NAME)/#' --files-from /proc/self/fd/0 -czf $(TARBALL) $(NAME).spec

.PHONY: srpm rpm
srpm: $(SRPM)
$(SRPM): $(TARBALL)
	mkdir -p $(RPMTOP)/{RPMS,SRPMS,SOURCES,BUILD}
	rpmbuild -ts \
	    --define="_topdir $(RPMTOP)" \
	    $(TARBALL)

rpm: $(SRPM)
	rpmbuild --define="_topdir $(RPMTOP)" --rebuild $<

clean:
	$(RM) $(NAME)*.tar.gz $(SPEC)
	$(RM) -r rpmtop
