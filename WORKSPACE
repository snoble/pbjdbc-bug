load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# bazel-skylib 0.8.0 released 2019.03.20 (https://github.com/bazelbuild/bazel-skylib/releases/tag/0.8.0)
skylib_version = "0.8.0"
http_archive(
    name = "bazel_skylib",
    type = "tar.gz",
    url = "https://github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib.{}.tar.gz".format (skylib_version, skylib_version),
    sha256 = "2ef429f5d7ce7111263289644d233707dba35e39696377ebab8b0bc701f7818e",
)

rules_scala_version="81238bba1b97f538a3fb30353829ff4d80550ff9" # update this as needed

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
http_archive(
    name = "io_bazel_rules_scala",
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    type = "zip",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip" % rules_scala_version,
    sha256 = "2104cab197ca601e13e0af64936e090ae74bc2c0e76eb4d0a1aa8180aef0959e",
)

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")
scala_register_toolchains()

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")
scala_repositories((
    "2.12.10",
    {
       "scala_compiler": "cedc3b9c39d215a9a3ffc0cc75a1d784b51e9edc7f13051a1b4ad5ae22cfbc0c",
       "scala_library": "0a57044d10895f8d3dd66ad4286891f607169d948845ac51e17b4c1cf0ab569d",
       "scala_reflect": "56b609e1bab9144fb51525bfa01ccd72028154fc40a58685a1e9adcbe7835730"
    }
))

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
git_repository(
   name = "rules_graal",
   remote = "git@github.com:andyscott/rules_graal.git",
   commit = "1b5f6deef8352c4b64541bb0f699fd2af5ae6b0b",
)

load("@rules_graal//graal:graal_bindist.bzl", "graal_bindist_repository")

graal_bindist_repository(
    name = "graal",
    version = "19.3.1",
    java_version = "8"
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.0"
RULES_JVM_EXTERNAL_SHA = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven10",
    artifacts = [
	"org.postgresql:postgresql:42.2.10",
    ],
    repositories = [
        "https://repo1.maven.org/maven2/",
    ],
    fetch_sources = True,
)

maven_install(
    name = "maven9",
    artifacts = [
	"org.postgresql:postgresql:42.2.9",
    ],
    repositories = [
        "https://repo1.maven.org/maven2/",
    ],
    fetch_sources = True,
)
