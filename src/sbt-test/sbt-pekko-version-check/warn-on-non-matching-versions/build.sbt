version      := "0.1"
scalaVersion := "2.13.14"

// direct dependency mismatch
libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-protobuf-v3" % "1.0.0",
  "org.apache.pekko" %% "pekko-testkit"     % "1.0.1"
)

pekkoVersionCheckFailBuildOnNonMatchingVersions := false

TaskKey[Unit]("check") := {
  val lastLog: File = BuiltinCommands.lastLogFile(state.value).get
  val last: String  = IO.read(lastLog)
  if (!last.contains("Non-matching Pekko module versions"))
    sys.error("expected mention of non-matching Pekko module versions")
}