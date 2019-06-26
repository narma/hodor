import sbt._

object Versions {
  val vScalaTest = "3.0.8"
  val vAirframeLog = "19.6.1"
  val vSlf4j = "1.7.26"
  val vSpark = "2.4.3"
}

object Dependencies {

  import Versions._

  lazy val sparkDeps = Seq(
    "spark-core",
    "spark-sql",
    "spark-streaming",
    "spark-mllib",
    "spark-sql-kafka-0-10",
    "spark-hive",
  ).map(x => "org.apache.spark" %% x % vSpark)

  lazy val appDeps = Seq(
    // logging
    "org.wvlet.airframe" %% "airframe-log" % vAirframeLog,
    "org.slf4j" % "slf4j-api" % vSlf4j,
    "org.slf4j" % "jcl-over-slf4j" % vSlf4j,
    "org.slf4j" % "log4j-over-slf4j" % vSlf4j,
    "org.slf4j" % "slf4j-jdk14" % vSlf4j,

    // strange overrides for spark
    "com.google.guava" % "guava" % "15.0" % Compile
  )

  lazy val testDeps = Seq(
    "org.scalatest" %% "scalatest" % vScalaTest
  ).map(_ % Test)

  lazy val allDeps = sparkDeps ++ appDeps ++ testDeps
}
