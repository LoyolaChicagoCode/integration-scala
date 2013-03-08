package edu.luc.etl.sigcse13.scala.integration

// begin-object-Integration
object Integration {

  // begin-Fx
  type Fx = Double => Double
  // end-Fx

  // begin-integrate
  def integrateSequential(a: Double, b: Double, rectangles: Int, f: Fx): Double = {
    val interval = (b - a) / rectangles
    val fxValues = (1 until rectangles).view map { n => f(a + n * interval) }
    (b - a) / rectangles * (f(a) / 2 + f(b) / 2 + fxValues.sum)
  }
  // end-integrate

  // begin-integrateParallel
  def integrateParallel(a: Double, b: Double, rectangles: Int, f: Fx): Double = {
    val interval = (b - a) / rectangles
    val fxValues = (1 until rectangles).par.view map { n => f(a + n * interval) }
    (b - a) / rectangles * (f(a) / 2 + f(b) / 2 + fxValues.sum)
  }
  // end-integrateParallel

  // begin-integrateParallelGranular
  def integrateParallelGranular(grainSize: Int)(a: Double, b: Double, rectangles: Int, f: Fx): Double = {
    require { rectangles % grainSize == 0 } // can relax this later
    val workers = rectangles / grainSize
    val interval = (b - a) / workers
    val fullIntegration = (0 until workers).par.view map { n =>
      val c = a + n * interval
      integrateSequential(c, c + interval, grainSize, f)
    }
    fullIntegration.sum
  }
  // end-integrateParallelGranular

}
// end-object-Integration