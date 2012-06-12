import sbt._
import sbt.Keys._

object TypoSafeBuild extends Build {
  lazy val typoSafe = Project(
    id = "typo-safe",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "typo-safe",
      organization := "com.tk.tp",
      version := "1.0",
      scalaVersion := "2.9.2"
    )
  )
}
