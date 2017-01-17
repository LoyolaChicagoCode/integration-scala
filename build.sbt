name := "integration-scala"

version := "0.1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

enablePlugins(JavaAppPackaging)
