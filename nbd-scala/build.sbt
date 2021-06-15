import org.apache.logging.log4j.core.config.composite.MergeStrategy

ThisBuild / name := "ndb-scala"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.5"

lazy val core = project
  .in(file("."))
  .settings(settings)
  .aggregate(
    cw1,
    cw2
  )

lazy val cw1 = project
  .settings(
    name := "cwiczenia1",
    settings
  )

lazy val cw2 = project
  .settings(
    name := "cwiczenia2",
    settings
  )

lazy val settings =
  commonSettings

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-deprecation",
  "-encoding",
  "utf8"
)

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)

//lazy val scalafmtSettings =
//  Seq(
//    scalafmtOnCompile := true,
//    scalafmtTestOnCompile := true,
//    scalafmtVersion := "1.2.0"
//  )

//lazy val assemblySettings = Seq(
//  assemblyJarName in assembly := name.value + ".jar",
//  assemblyMergeStrategy in assembly := {
//    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
//    case "application.conf"            => MergeStrategy.concat
//    case x =>
//      val oldStrategy = (assemblyMergeStrategy in assembly).value
//      oldStrategy(x)
//  }
//)