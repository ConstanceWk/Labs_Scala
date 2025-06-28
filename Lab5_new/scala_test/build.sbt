val scala3Version = "3.7.1"

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.1"  

lazy val root = (project in file("."))
  .settings(
    name := "scala_test",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.17" % Test,
      "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % Test,
      "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
    )
  )