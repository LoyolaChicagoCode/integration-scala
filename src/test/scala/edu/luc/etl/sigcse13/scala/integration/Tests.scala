package edu.luc.etl.sigcse13.scala.integration

import org.junit.Test
import org.junit.Assert.*
import Integration.*
import Fixtures.*

/**
  * Simple JUnit-based tests.
  */
class Tests:

  @Test def testSequential(): Unit =
    assertEquals(333.3, integrateSequential(0, 10, 1000, sqr), 0.1)

  @Test def testParallel(): Unit =
    assertEquals(333.3, integrateParallel(0, 10, 1000, sqr), 0.1)

  @Test def testParallelGranular(): Unit =
    assertEquals(333.3, integrateParallelGranular(10)(0, 10, 1000, sqr), 0.1)

end Tests
