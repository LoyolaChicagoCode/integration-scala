import com.typesafe.sbt.SbtStartScript

name := "integration-scala"

version := "0.0.2"

scalaVersion := "2.10.1"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10-M4" % "test"

seq(SbtStartScript.startScriptForClassesSettings: _*)
