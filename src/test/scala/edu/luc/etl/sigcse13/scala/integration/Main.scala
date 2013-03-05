package edu.luc.etl.sigcse13.scala.integration

object Main extends {
  import Integration.integrate
  import Integration.integrateParallel

  import Fixtures.sqr

  def main(args: Array[String]) {
    try {
      require { 2 == args.length }
      val rectangles = math.max(args(0).toInt, 1000)
      val n  = math.max(args(1).toInt, 1)
      timedRunSquare(rectangles, n)
    } catch {
      case _: Throwable =>
        Console.err.println("usage: rectangles (>= 1000) numberOfRuns (>= 1)")
    }
  }

  def timedRunSquare(rectangles : Int, n : Int) {
    val area = integrate(0, 10, rectangles, sqr)
    println("Area = ", area, "computed; now timing ", n, " iterations")
    val time0 = System.currentTimeMillis
    (1 to n) foreach { _ =>
    	val area = integrate(0, 10, rectangles, sqr)
    }
    val time1 = System.currentTimeMillis - time0
    println("total time = " + time1)
    println("average time = " + (time1 + 0.0) / n)

    val area2 = integrate(0, 10, rectangles, sqr)
    println("Area = ", area2, "computed in parallel; now timing ", n, " iterations")
    val time2 = System.currentTimeMillis
    (1 to n) foreach { _ =>
    	val area = integrateParallel(0, 10, rectangles, sqr)
    }
    val time3 = System.currentTimeMillis - time2
    println("total time = " + time3)
    println("average time = " + (time3 + 0.0) / n)

  }
}