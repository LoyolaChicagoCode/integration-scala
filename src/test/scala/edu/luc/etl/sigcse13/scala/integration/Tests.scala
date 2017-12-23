package edu.luc.etl.sigcse13.scala.integration

import org.junit.Test
import org.junit.Assert._
import Integration._
import Fixtures._

/**
  * Simple JUnit-based tests.
  */
class Tests {

  @Test def testSequential() {
    assertEquals(333.3, integrateSequential(0, 10, 1000, sqr), 0.1)
  }

  @Test def testParallel() {
    assertEquals(333.3, integrateParallel(0, 10, 1000, sqr), 0.1)
  }

  @Test def testParallelGranular() {
    assertEquals(333.3, integrateParallelGranular(10)(0, 10, 1000, sqr), 0.1)
  }
}
