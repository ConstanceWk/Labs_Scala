error id: file://<WORKSPACE>/lab6_unit/build.sbt:
file://<WORKSPACE>/lab6_unit/build.sbt
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scalaVersion.
	 -scalaVersion#
	 -scalaVersion().
	 -scala/Predef.scalaVersion.
	 -scala/Predef.scalaVersion#
	 -scala/Predef.scalaVersion().
offset: 12
uri: file://<WORKSPACE>/lab6_unit/build.sbt
text:
```scala
ThisBuild / @@scalaVersion := "3.3.3"


lazy val root = (project in file("."))
  .settings(
    name := "lab6_unit",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalatest" % "scalatest_2.13" % "3.2.17" % Test,
      "org.scalatestplus" % "scalacheck-1-17_2.13" % "3.2.17.0" % Test,
      "org.scalacheck" % "scalacheck_2.13" % "1.17.0" % Test,
      "org.mockito" % "mockito-scala_2.13" % "1.17.14" % Test,
      "org.mockito" % "mockito-scala-scalatest_2.13" % "1.17.14" % Test
    )
  )

```


#### Short summary: 

empty definition using pc, found symbol in pc: 