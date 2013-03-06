# Overview

An implementation of simple trapezoidal integration in Scala.

# Prerequisites

## Required

- Java Development Kit (JDK) through your package management system or from [Oracle](http://www.oracle.com/technetwork/java/javase/downloads)
- [sbt](http://www.scala-sbt.org/)

These really are the only required prerequisites.

## Optional

- [Eclipse 4.2.x IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/junosr1)
- [Scala IDE Eclipse plugin](http://scala-ide.org/download/milestone.html#scala_ide_21_milestone_3) corresponding to your Eclipse version

# Command-line

## Running the sample application

During development:

    $ sbt 'run rectangles (>= 1000) numberOfRuns (>= 1)'

During production, first create the startup script:

    $ sbt stage

Then run the application outside of sbt like this:

    $ target/start rectangles (>= 1000) numberOfRuns (>= 1)

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
