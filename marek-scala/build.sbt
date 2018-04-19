import sbt.Keys._
import sbt._
import Dependencies._

name := "marek"

autoScalaLibrary := false

val setts = Seq(
  scalaVersion := Versions.scala,
  crossScalaVersions := Versions.scalas,
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
  mainClass in assembly := Some("pl.marek.Main")
)

lazy val root =
  Project(id = "marek", base = file("."))
    .settings(setts)
    .settings(libraryDependencies ++= allLibs(scalaVersion.value))
