all: rpm

rpmrelease:=1
rpmversion=1.0.0.7
RPMTOP=$(shell bash -c "pwd -P")/rpmtop
NAME=ovirt-engine-sdk-java
SPEC=$(NAME).spec

TARBALL=$(NAME)-$(rpmversion).tar.gz
SRPM=$(RPMTOP)/SRPMS/$(NAME)-$(rpmversion)-$(rpmrelease)*.src.rpm

.PHONY: tarball
tarball: $(TARBALL)
$(TARBALL): Makefile #$(TESTS)
	git archive --format=tar --prefix $(NAME)/ HEAD | gzip > $(TARBALL)

.PHONY: srpm rpm
srpm: $(SRPM)
$(SRPM): $(TARBALL) $(NAME).spec.in
	sed 's/^Version:.*/Version: $(rpmversion)/;s/^Release:.*/Release: $(rpmrelease)%{dist}/;s/%{release}/$(rpmrelease)/' $(NAME).spec.in > $(SPEC)
	mkdir -p $(RPMTOP)/{RPMS,SRPMS,SOURCES,BUILD}
	rpmbuild -bs \
	    --define="_topdir $(RPMTOP)" \
	    --define="_sourcedir ." $(SPEC)

rpm: $(SRPM)
	rpmbuild --define="_topdir $(RPMTOP)" --rebuild $<

clean:
	$(RM) $(NAME)*.tar.gz $(SPEC)
	$(RM) -r rpmtop
