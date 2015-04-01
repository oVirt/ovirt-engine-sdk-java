Waht is this?
=============

The files in this directory are resources used by the code generator.

`rsdl.xml` This file contains the RSDL metadata. It is extracted from the
engine artifacts using the `update-metadata` profile and stored in the
repository in order to simplify regeneration of the SDK.

`api.xsd` This file contains the XML schema. Like the RSDL metadata it is
extracted from the engine artifacts using the `update-metadata` profile.

`api.xjb` This file contains the binding definitions used by the XJC
compiler when generating the Java source code for the entities. It
itsn't extracted from the engine, and it is necessary because the SDK
uses different bindings than the engine.

`memory.properties` This file stores information that the code generator needs to
remember from one run to the next. For example, it needs to remember
the order of the headers that were used to generate a method, as
otherwise adding new headers (or changing the order in the RSDL)
would produce serious backwards compatibility issues. For example,
currently the order of the headers for the method to add a cluster
is `Expect` and then `Correlation-Id`, so the generated code for one
of the `add` methods of the `Clusters` class looks like this:

    public Cluster add(Cluster cluster, String expect, String correlationId)

If this order changes, because new headers are added, or simply the RSDL
is generated in a different way then the generated code could become
like this:

    public Cluster add(Cluster cluster, String correlationId, String expect)

That is extremelly dangerous, as it would change the meaning of the method
but would still compile fine. To avoid this situation the memory file is
used to remember, for example, the order of headers.
