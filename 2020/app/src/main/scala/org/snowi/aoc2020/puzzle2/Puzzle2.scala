/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle2

object Puzzle2 {
  def main(args: Array[String]): Unit = {
    println("This is puzzle 2")
    var correctEntries = checkPwEntriesV2(readPwFile("puzzle2/input.txt"))
    println("Result puzzle 2: " + correctEntries)

  }

  def checkPolicy1(pwEntry: String): Boolean = {
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

  def checkPolicy2(pwEntry: String): Boolean = {
    val tokens = pwEntry.replace("-", " ").split(" ")
    val pw = tokens(3)
    val lower = tokens(0).toInt - 1
    val upper = tokens(1).toInt - 1
    val c = tokens(2).replace(":", "").charAt(0)
    var i = 0
    var matches = 0

    return (pw.charAt(lower) == c && pw.charAt(upper) != c) || (pw.charAt(
      lower
    ) != c && pw.charAt(upper) == c)
  }

  def readPwFile(filename: String): List[String] = {
    val bufferedSource = io.Source.fromResource(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def checkPwEntries(entries: List[String]): Int = {
    var correct = 0
    for (pwEntry <- entries if checkPolicy1(pwEntry)) {
      correct += 1
      println(pwEntry)
    }

    correct
  }

  def checkPwEntriesV2(entries: List[String]): Int = {
    var correct = 0
    for (pwEntry <- entries if checkPolicy2(pwEntry)) {
      correct += 1
      println(pwEntry)
    }

    correct
  }
}
