error id: file://<WORKSPACE>/lab6_unit/build.sbt:`<none>`.
file://<WORKSPACE>/lab6_unit/build.sbt
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 190
uri: file://<WORKSPACE>/lab6_unit/build.sbt
text:
```scala
ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "lab6_unit",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalates@@t" %% "scalatest" % "3.2.17" % Test,
      "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % Test,
      "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
    )
  )

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.