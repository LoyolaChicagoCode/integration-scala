name := "integration-scala"

version := "0.2"

scalaVersion := "3.2.1"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls", "-Ysafe-init", "-language:strictEquality")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

enablePlugins(JavaAppPackaging)
