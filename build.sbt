ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "myBackendApi",
    libraryDependencies += "com.lihaoyi" %% "cask" % "0.10.2", //Dependence of Cask, for webserver creation
    libraryDependencies += "com.lihaoyi" %% "upickle" % "4.2.1", //Dependence of uPickle, for JSON lib
    fork := true
  )
