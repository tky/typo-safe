import sbt._
import sbt.Keys._

object TypoSafeBuild extends Build {
 val io = Seq(
    "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.0",
    "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.0"
  )
  val test = Seq(
    "org.specs2" % "specs2_2.9.1" % "1.9"
  )
  val default = io ++ test

  lazy val typoSafe = Project(
    id = "typo-safe",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "typo-safe",
      organization := "com.tk.tp",
      version := "1.0",
      scalaVersion := "2.9.1",
      resolvers += "scala-tools releases"  at "http://scala-tools.org/repo-releases",
      resolvers += "scala-tools snapshots" at "http://scala-tools.org/repo-snapshots",
      resolvers += "releases"  at "http://oss.sonatype.org/content/repositories/releases",
      resolvers += "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
      resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      libraryDependencies := default
    )
  )
}
