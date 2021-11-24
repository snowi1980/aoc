/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle1

object Puzzle1 {
  def main(args: Array[String]): Unit = {
    answer()
  }

  def answer(): Unit = {
    val input = readFile("puzzle1/input.txt")
    println()
    println("--------------- Puzzle 01 ---------------")
    println("Result puzzle 2 part 1: " + answer1(input))
    println("Result puzzle 2 part 2: " + answer2(input))
    println()
  }

  def answer1(expenseReport: Array[Int]): Int = {
    var y = 0
    for (x <- expenseReport) {
      for (i <- 0 to (expenseReport.length - 1)) {
        y = expenseReport(i)
        if (x + y == 2020) {
          println(f"$x + $y")
          return x * y
        }
      }
    }
    return -1;
  }

  def answer2(expenseReport: Array[Int]): Int = {
    var y = 0
    var z = 0
    for (x <- expenseReport) {
      for (i <- 0 to (expenseReport.length - 1)) {
        y = expenseReport(i)
        if (x + y < 2020) {
          for (j <- 0 to (expenseReport.length - 1)) {
            z = expenseReport(j)
            if (x + y + z == 2020) {
              println(f"$x + $y + $z = 2020")
              return x * z * y
            }
          }
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
