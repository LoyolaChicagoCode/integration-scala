import com.typesafe.sbt.SbtStartScript

name := "integration-scala"

version := "0.1.0"

scalaVersion := "2.10.4"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

seq(SbtStartScript.startScriptForClassesSettings: _*)
