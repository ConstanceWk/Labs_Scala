ThisBuild / scalaVersion := "3.3.3"

// ⚠️ Pour compatibilité Mockito avec Java 23+
ThisBuild / javaOptions += "-Dnet.bytebuddy.experimental=true"

lazy val root = (project in file("."))
  .settings(
    name := "lab6_unit",
    version := "0.1.0",

    libraryDependencies ++= Seq(

  // === [Tests unitaires & mocks] ===
  "org.scalatest"         %% "scalatest"                      % "3.2.18" % Test,
  "org.mockito"           %  "mockito-core"                   % "5.12.0" % Test,
  "org.scalatestplus"     %% "scalacheck-1-17"                % "3.2.18.0" % Test,
  "org.scalatestplus"     %% "mockito-4-11"                   % "3.2.18.0" % Test,
  "org.typelevel"         %% "munit-cats-effect-3"            % "1.0.7" % Test,

  // === [Base de données embarquée] ===
  "com.h2database"        %  "h2"                              % "2.2.224" % Test,

  // === [HTTP4s + JSON] ===
  "org.http4s"            %% "http4s-dsl"                     % "0.23.23",
  "org.http4s"            %% "http4s-ember-server"            % "0.23.23",
  "org.http4s"            %% "http4s-ember-client"            % "0.23.23",
  "org.http4s"            %% "http4s-circe"                   % "0.23.23",

  // === [Circe JSON] ===
  "io.circe"              %% "circe-generic"                  % "0.14.6",
  "io.circe"              %% "circe-literal"                  % "0.14.6",
  "io.circe"              %% "circe-parser"                   % "0.14.6",

  // === [Testcontainers - PostgreSQL & Kafka] ===
  "com.dimafeng"          %% "testcontainers-scala-scalatest"   % "0.40.12" % Test,
  "org.testcontainers"    %  "postgresql"                        % "1.19.3"  % Test,
  "com.dimafeng"          %% "testcontainers-scala-postgresql"  % "0.40.12" % Test,
  "com.dimafeng"          %% "testcontainers-scala-kafka"       % "0.40.12" % Test,
  "org.apache.kafka"      %  "kafka-clients"                    % "3.4.0"   % Test,

  // === [Configuration] ===
  "com.typesafe"          %  "config"                           % "1.4.3",

  // === [WireMock] ===
  "com.github.tomakehurst" % "wiremock-jre8"                   % "2.35.0" % Test,

  // === [STTP client] ===
  "com.softwaremill.sttp.client3" %% "core"                    % "3.9.0",

  // === [ZIO core + test] ===
  "dev.zio" %% "zio"          % "2.0.21",
  "dev.zio" %% "zio-test"     % "2.0.21" % Test,
  "dev.zio" %% "zio-test-sbt" % "2.0.21" % Test,

  // === [Pact JVM] ===
  "au.com.dius.pact.consumer" % "junit"  % "4.3.10" % Test,
  "au.com.dius.pact.consumer" % "junit5" % "4.6.10" % Test,
  "au.com.dius.pact.core"     % "model"  % "4.6.8"  % Test,
)

  )
