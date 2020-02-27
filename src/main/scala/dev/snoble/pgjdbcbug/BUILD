load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary", "scala_library")

scala_library(
    name = "pgjdbc-bug-9",
    srcs = ["Bug.scala"],
    deps = ["//:postgres-jdbc-9"],
)

scala_library(
    name = "pgjdbc-bug-10",
    srcs = ["Bug.scala"],
    deps = ["//:postgres-jdbc-10"],
)

scala_binary(
    name = "pgjdbc-bug-9-jvm",
    deps = [":pgjdbc-bug-9"],
    main_class = "dev.snoble.pgjdbcbug.Bug",
)

scala_binary(
    name = "pgjdbc-bug-10-jvm",
    deps = [":pgjdbc-bug-10"],
    main_class = "dev.snoble.pgjdbcbug.Bug",
)

load("@rules_graal//graal:graal.bzl", "graal_binary")

graal_binary(
    name = "pgjdbc-bug-9-graal",
    deps = [":pgjdbc-bug-9"],
    main_class = "dev.snoble.pgjdbcbug.Bug",
    graal_extra_args = [
        "--enable-http",
        "--enable-https",
	"--initialize-at-build-time=org.postgresql.Driver",
	"--initialize-at-build-time=org.postgresql.util.SharedTimer",
	"-H:+TraceClassInitialization",
    ],
)

graal_binary(
    name = "pgjdbc-bug-10-graal",
    deps = [":pgjdbc-bug-10"],
    main_class = "dev.snoble.pgjdbcbug.Bug",
    graal_extra_args = [
        "--enable-http",
        "--enable-https",
	"--initialize-at-build-time=org.postgresql.Driver",
	"--initialize-at-build-time=org.postgresql.util.SharedTimer",
	"-H:+TraceClassInitialization",
    ],
    reflection_configuration = "reflectconfig",
)
