lazy val commonSettings = Seq(
  name := "Scala Bank",
  organization := "com.suru.scalabank",
  version := "1.0.0",
  scalaVersion := "2.13.3",
  scalacOptions := Seq("-unchecked", "-language:postfixOps")
)

lazy val libraries = {
  Seq(
    guice,
    evolutions,
    jdbc,
    ws,
    "org.postgresql" % "postgresql" % "42.2.18",
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
  )
}

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(javacOptions ++= Seq("-target", "11"))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= libraries)
  .settings(
    inConfig(Test)(
      Seq(
        sourceDirectory := baseDirectory.value / "tests/unit/",
        scalaSource := sourceDirectory.value / "scala",
        javaSource := sourceDirectory.value / "java",
        javaOptions ++= Seq("-Dconfig.resource=application-unit-test.conf"),
        fork := true
      )
    ),
    inConfig(IntegrationTest)(
      Seq(
        sourceDirectory := baseDirectory.value / "tests/integration/",
        scalaSource := sourceDirectory.value / "scala",
        javaSource := sourceDirectory.value / "java",
        javaOptions ++= Seq("-Dconfig.resource=application-integration-test.conf"),
        fork := true
      )
    )
  )
