package edu.luc.etl.sigcse13.scala.integration

object Main extends App {
  import Integration.integrate
  import Fixtures.sqr

  val area = integrate(0, 10, 1000, sqr)
  println("Area = " + area)
}