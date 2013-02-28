# Overview

An implementation of simple trapezoidal integration in Scala.

# Prerequisites

## Required

- [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads)
- [sbt](http://www.scala-sbt.org/)

These really are the only required prerequisites.

## Optional

- [Eclipse 4.2.x IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/junosr1)
- [Scala IDE Eclipse plugin](http://scala-ide.org/download/milestone.html#scala_ide_21_milestone_3) corresponding to your Eclipse version

# Command-line

## Running the sample application

    $ sbt test:run

## Running the tests

    $ sbt test:test

or simply

    $ sbt test

# Eclipse

## Generating the configuration files

    $ sbt eclipse

## Running the sample application

- navigate to test > edu.luc.etl.sigcse13.scala.integration > Main.scala
- right-click Main.scala > Run As > Scala Application

## Running the tests

- right-click tests > Run As > Scala JUnit tests

See also near the end of [this document](http://scala-ide.org/docs/user/testingframeworks.html).
