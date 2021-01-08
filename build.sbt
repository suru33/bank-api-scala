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
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
  )
}

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(javacOptions ++= Seq("-target", "11"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= libraries)
