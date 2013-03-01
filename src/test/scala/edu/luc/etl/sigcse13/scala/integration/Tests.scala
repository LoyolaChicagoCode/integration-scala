package edu.luc.etl.sigcse13.scala.integration

import org.junit.Test
import org.junit.Assert._
import Integration.integrate
import Fixtures._

/**
 * Simple JUnit-based tests.
 */
class Tests {

  @Test def testSquare() {
    assertEquals(333.3, integrate(0, 10, 1000, sqr), 0.1)
  }
}
