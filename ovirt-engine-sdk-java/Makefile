all: rpm

rpmrelease:=1
rpmversion=4.0.0.1
RPMTOP=$(shell bash -c "pwd -P")/rpmtop
NAME=ovirt-engine-sdk-java
SPEC=$(NAME).spec

TARBALL=$(NAME)-$(rpmversion).tar.gz
SRPM=$(RPMTOP)/SRPMS/$(NAME)-$(rpmversion)-$(rpmrelease)*.src.rpm

$(NAME).spec: $(NAME).spec.in
	sed 's/^Version:.*/Version: $(rpmversion)/;s/^Release:.*/Release: $(rpmrelease)%{dist}/;s/%{release}/$(rpmrelease)/' $(NAME).spec.in > $(SPEC)

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
