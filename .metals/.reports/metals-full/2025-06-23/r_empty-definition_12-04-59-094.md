error id: file://<WORKSPACE>/Lab5_new/scala_test/build.sbt:`<none>`.
file://<WORKSPACE>/Lab5_new/scala_test/build.sbt
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 205
uri: file://<WORKSPACE>/Lab5_new/scala_test/build.sbt
text:
```scala
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala_test",
    libraryDependencies ++= Seq(
      // VERSIONS@@ COMPATIBLES IMPORTANTES
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
      // Enlève ScalaCheck pour l'instant si ça pose problème
    )
  )
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.