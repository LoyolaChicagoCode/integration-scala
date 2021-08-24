name := "integration-scala"

version := "0.2"

scalaVersion := "3.0.1"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

enablePlugins(JavaAppPackaging)

scalacOptions ++= Seq("-rewrite", "-new-syntax")
