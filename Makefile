GIT_HEAD=$(shell git log -1 --pretty=format:%h)
DATE=$(shell date --utc +%Y%m%d)
GIT_RELEASE=$(DATE).git$(GIT_HEAD)
PROJ_DIR=sdk

.PHONY: dist
dist:
	env rpmsuffix=$(GIT_RELEASE) $(MAKE) -C $(PROJ_DIR) dist; mv $(PROJ_DIR)/*.gz .

clean:
	$(MAKE) -C $(PROJ_DIR) clean; rm *gz
