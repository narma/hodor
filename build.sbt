import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "Hodor",
    libraryDependencies ++= allDeps,
    mainClass := Some("hodor.Main"),
    // run options
    run / fork := true,
    run / javaOptions := Seq(
      "-server",
      "-Xms1G", "-Xmx1G",
      "-Dspark.master=local[*]" // use local at development
    ),
    run / outputStrategy := Some(StdoutOutput),
    run / connectInput  := true,
    Global / cancelable := true,
    // loggers
    excludeDependencies := Seq(
      ExclusionRule("ch.qos.logback", "logback-classic"),
      ExclusionRule("org.slf4j", "slf4j-log4j12"),
      ExclusionRule("org.slf4j", "jul-to-slf4j"),
    ),
    scalacOptions := Seq(
      "-Ybackend-parallelism", "2",
      "-language:implicitConversions",
      "-language:higherKinds",
      // warnings
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused:_",
      "-Ywarn-extra-implicit",
      "-Ywarn-self-implicit",
      "-Xlint:_"
    ),
  )
