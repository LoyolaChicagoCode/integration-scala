name := "integration-scala"

version := "0.2"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

enablePlugins(JavaAppPackaging)
