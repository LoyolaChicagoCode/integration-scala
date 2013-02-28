package edu.luc.etl.sigcse13.scala.integration

object Integration {

  type Fx = Double => Double

  def integrate(a: Double, b: Double, g: Int, f: Fx): Double = {
    val interval = (b - a) / g
    val fxValues = (1 until g) map { n => f(a + n * interval) }
    (b - a) / g * (f(a) / 2 + f(b) / 2 + fxValues.sum)
  }
}