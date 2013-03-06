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
      timedRunSquare(rectangles, n, "sequentially", integrate)
      timedRunSquare(rectangles, n, "in parallel", integrateParallel)
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
<<<<<<< local
  def timedRunSquare(rectangles : Int, n : Int) {
  	// run it once to see whether we get any artifacts

  	timeThis("sequential integrate()") {
       val area = integrate(0, 10, rectangles, sqr)
       println("Area = " + area)
=======
  def timedRunSquare(rectangles : Int, n : Int, how: String,
      integrationStrategy: (Double, Double, Int, Fx) => Double) {
    val area = integrationStrategy(0, 10, rectangles, sqr)
    println("Area = " + area + " computed " + how + "; now timing " + n + " iterations")
    val time0 = System.currentTimeMillis
    (1 to n) foreach { _ =>
    	val area = integrationStrategy(0, 10, rectangles, sqr)
>>>>>>> other
    }
<<<<<<< local

  	timeThis("sequential integrate() " + n + " times") {
       (1 to n) foreach { _ =>
          val area = integrate(0, 10, rectangles, sqr)
       }
    }

    timeThis("parallel integrate()") {
       val area = integrateParallel(0, 10, rectangles, sqr)
       println("Area = " + area)
    }

    timeThis("parallel integrate() " + n + " times") {
       (1 to n) foreach { _ =>
          val area = integrateParallel(0, 10, rectangles, sqr)
       }
    }

=======
    val time1 = System.currentTimeMillis - time0
    println("total time = " + time1)
    println("average time = " + (time1.toFloat / n).toInt)
>>>>>>> other
  }
  // end-timedRun
}