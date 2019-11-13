name := """sbt-akka-version-check"""
organization := "com.lightbend.akka"
version := "0.1-SNAPSHOT"

sbtPlugin := true

bintrayPackageLabels := Seq("sbt","plugin")
bintrayVcsUrl := Some("""git@github.com:com.lightbend.akka/sbt-akka-version-check.git""")

initialCommands in console := """import com.lightbend.akka.sbtvc._"""

enablePlugins(ScriptedPlugin)
// set up 'scripted; sbt plugin for testing sbt plugins
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
