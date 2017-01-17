# Overview

An implementation of simple trapezoidal integration in Scala.

# Prerequisites

- Java Development Kit (JDK) through your package management system or from [Oracle](http://www.oracle.com/technetwork/java/javase/downloads)
- [sbt](http://www.scala-sbt.org/)

These really are the only required prerequisites.

# Command-line

## Running the sample application

During development:

    $ sbt 'run rectangles (>= 1000) numberOfRuns (>= 1)'

During production, first create the startup script:

    $ sbt stage

Then run the application outside of sbt like this:

    $ ./target/universal/stage/bin/integration-scala rectangles (>= 1000) numberOfRuns (>= 1)

## Running the tests

    $ sbt test:test

or simply

    $ sbt test
