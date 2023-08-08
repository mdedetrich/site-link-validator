import sbt._

val PekkoVersion = "1.0.1"
val PekkoHttpVersion = "1.0.0"

lazy val `site-link-validator` = project.in(file(".")).aggregate(core).settings(publish / skip := true)

lazy val core = project.settings(
  name := "site-link-validator",
  run / javaOptions += "-Djavax.net.debug=ssl:handshake:verbose",
  libraryDependencies ++= Seq(
    "org.jsoup" % "jsoup" % "1.14.3",
    "org.apache.pekko" %% "pekko-stream" % PekkoVersion,
    "org.apache.pekko" %% "pekko-http" % PekkoHttpVersion,
    "org.apache.pekko" %% "pekko-stream-testkit" % PekkoVersion % Test,
    "org.apache.pekko" %% "pekko-stream-typed" % PekkoVersion,
    "org.apache.pekko" %% "pekko-actor-typed" % PekkoVersion,
    "org.apache.pekko" %% "pekko-slf4j" % PekkoVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.11"))

inThisBuild(
  Seq(
    organization := "net.runne",
    organizationHomepage := Some(url("https://github.com/ennru/")),
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url("https://github.com/ennru/site-link-validator")),
    scmInfo := Some(
      ScmInfo(url("https://github.com/ennru/site-link-validator"), "git@github.com:ennru/site-link-validator.git")),
    developers += Developer(
      "contributors",
      "Contributors",
      "https://github.com/ennru/site-link-validator/graphs/contributors",
      url("https://github.com/ennru/site-link-validator/graphs/contributors")),
    scalafmtOnCompile := true,
    Test / testOptions += Tests.Argument("-oDF"),
    scalaVersion := "2.13.10",
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xlint",
      "-Ywarn-dead-code",
      "-target:jvm-1.8")))
