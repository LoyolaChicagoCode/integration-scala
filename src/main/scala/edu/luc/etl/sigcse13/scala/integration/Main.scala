package edu.luc.etl.sigcse13.scala.integration

import Fixtures.sqr
import Integration.integrate
import Integration.integrateParallel

object Main extends {
  import Integration._

  import Fixtures.sqr

  def main(args: Array[String]) {
    try {
      require { 2 == args.length }
      val rectangles = math.max(args(0).toInt, 1000)
      val n  = math.max(args(1).toInt, 1)
      timedRun(rectangles, 1, "priming the pump by running sequentially once", integrate)
      timedRun(rectangles, n, "sequentially", integrate)
      timedRun(rectangles, n, "in parallel", integrateParallel)
    } catch {
      case _: Throwable =>
        Console.err.println("usage: rectangles (>= 1000) numberOfRuns (>= 1)")
    }
  }

  def timeThis[A](s : String)(block : => A) : A = {
  	val time0 = System.currentTimeMillis
    val b = block
  	val time1 = System.currentTimeMillis - time0
  	println("Timing " + s + " = " + time1)
  	b
  }

  // begin-timedRun
  def timedRun(rectangles : Int, n : Int, how: String,
      integrationStrategy: (Double, Double, Int, Fx) => Double) {

    timeThis(how) {
       val area = integrationStrategy(0, 10, rectangles, sqr)
       println("Area = " + area + " computed " + how + "; now timing " + n + " iterations")
    }
  }
  // end-timedRun
}