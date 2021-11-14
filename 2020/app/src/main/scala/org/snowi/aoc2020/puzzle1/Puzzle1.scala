/*
 * https://adventofcode.com/2020/day/1
 */
package org.snowi.aoc2020.puzzle1

object Puzzle1 {
  def main(args: Array[String]): Unit = {
    
    println(answer(readFile("puzzle1/input.txt")))
  }

  def greeting(): String = "Hello, world!"

  def answer(expenseReport: Array[Int]): Int = {
    var y = 0
    for (x <- expenseReport) {
      for (i <- 0 to (expenseReport.length - 1)) {
        y = expenseReport(i)
        println(f"$x + $y")
        if (x + y == 2020) {
          return x * y
        }
      }
    }
    return -1;
  }

  def readFile(filename: String): Array[Int] = {
    val bufferedSource = io.Source.fromResource(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines.map(_.toInt).toArray
  }

}
