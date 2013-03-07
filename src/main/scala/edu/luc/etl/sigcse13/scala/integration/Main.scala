package edu.luc.etl.sigcse13.scala.integration

import Integration._
import Fixtures.sqr

object Main extends {

  def main(args: Array[String]) {
    try {
      require { 2 <= args.length }
      val rectangles = math.max(args(0).toInt, 1000)
      val n  = math.max(args(1).toInt, 1)
      val grainSize = if (args.length == 3) math.min(args(2).toInt, rectangles) else rectangles

      timedRun(rectangles, n, "sequentially", integrateSequential)
      timedRun(rectangles, n, "in parallel", integrateParallel)

      def bindNumWorkersToIntegrateGranular(a : Double, b : Double, g : Int, f : Fx) : Double = {
        integrateParallelGranular(a, b, g, grainSize, f)
      }
      timedRun(rectangles, n, "in parallel with " + grainSize + " rectangles per serial worker", bindNumWorkersToIntegrateGranular)

    } catch {
      case _: NumberFormatException => usage()
      case _: IllegalArgumentException => usage()
    }
  }

  def usage() { Console.err.println("usage: rectangles (>= 1000) numberOfRuns (>= 1) [ grainSize (rectangles % grainSize == 0) ]") }

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
       print("Computing area " + how + "; now timing " + n + " iterations")
       val area: Double = (1 to n).map { _ => integrationStrategy(0, 10, rectangles, sqr) }.head
       println("; area = " + area)
    }
  }
  // end-timedRun
}