/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle2

import java.util.regex.Pattern

object Puzzle2 {
  def main(args: Array[String]): Unit = {
    println("This is puzzle 2")
    var correctEntries = checkPwEntries(readPwFile("puzzle2/input.txt"))
    println("Result puzzle 2: " + correctEntries)

  }

  def checkPw(pwEntry: String): Boolean = {
    val tokens = pwEntry.replace("-", " ").split(" ")
    val pw = tokens(3)
    val lower = tokens(0).toInt
    val upper = tokens(1).toInt
    val c = tokens(2).replace(":", "").charAt(0)
    var i = 0
    var matches = 0

    while (i < pw.length) {
      if (pw.charAt(i) == c) {
        matches += 1
      }
      i += 1
    }
    return lower <= matches && matches <= upper
  }

  def readPwFile(filename: String): List[String] = {
    val bufferedSource = io.Source.fromResource(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def checkPwEntries(entries: List[String]): Int = {
    var correct = 0
    for (pwEntry <- entries if checkPw(pwEntry)) {
      correct += 1
      println(pwEntry)
    }

    correct
  }
}
