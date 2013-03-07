package edu.luc.etl.sigcse13.scala.integration

// begin-object-Integration
object Integration {

  type Fx = Double => Double

  // begin-integrate
  def integrate(a: Double, b: Double, g: Int, f: Fx): Double = {
    val interval = (b - a) / g
    val fxValues = (1 until g).view map { n => f(a + n * interval) }
    (b - a) / g * (f(a) / 2 + f(b) / 2 + fxValues.sum)
  }
  // end-integrate

  // begin-integrateParallel
  def integrateParallel(a: Double, b: Double, g: Int, f: Fx): Double = {
    val interval = (b - a) / g
	val fxValues = (1 until g par).view map { n => f(a + n * interval) }
   	(b - a) / g * (f(a) / 2 + f(b) / 2 + fxValues.sum)
  }
  // end-integrateParallel

 // begin-integrateParallelGranular
  def integrateParallelGranular(a: Double, b: Double, g: Int, grainSize : Int, f: Fx): Double = {
    require { g % grainSize == 0 } // can relax this later
    val interval = (b - a) / grainSize
    val workers = g / grainSize
    val fullIntegration = (0 until workers).par.map { n => integrate(a + n * interval, a + (n + 1) * interval, grainSize, f) }
    fullIntegration.sum
  }
  // end-integrateParallelGranular

}
// end-object-Integration