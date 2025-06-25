ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "myBackendApi",
    libraryDependencies += "com.lihaoyi" %% "cask" % "0.10.2",
    fork := true
  )
