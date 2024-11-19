/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle2

object Puzzle2 {

  val IDX_LOWER_TOKEN = 0
  val IDX_UPPER_TOKEN = 1
  val IDX_CHAR_TOKEN = 2
  val IDX_PW_TOKEN = 3

  def main(args: Array[String]): Unit = {
    answer()
  }

  def answer(): Unit = {
    val input = readPwFile("puzzle2/input.txt")
    println()
    println("--------------- Puzzle 02 ---------------")
    println("Result puzzle 2 part 1: " + checkPwEntries(input))
    println("Result puzzle 2 part 2: " + checkPwEntriesV2(input))
    println()
  }

  def checkPolicy1(pwEntry: String): Boolean = {
    val tokens = pwEntry.replace("-", " ").split(" ")
    val pw = tokens(IDX_PW_TOKEN)
    val lower = tokens(IDX_LOWER_TOKEN).toInt
    val upper = tokens(IDX_UPPER_TOKEN).toInt
    val c = tokens(2).replace(":", "").charAt(0)
    var i = 0
    var matches = 0

    while (i < pw.length) {
      if (pw.charAt(i) == c) {
        matches += 1
      }
      i += 1
    }
    lower <= matches && matches <= upper
  }

  def checkPolicy2(pwEntry: String): Boolean = {
    val tokens = pwEntry.replace("-", " ").split(" ")
    val pw = tokens(IDX_PW_TOKEN)
    val lower = tokens(IDX_LOWER_TOKEN).toInt - 1
    val upper = tokens(IDX_UPPER_TOKEN).toInt - 1
    val c = tokens(IDX_CHAR_TOKEN).replace(":", "").charAt(0)

    (pw.charAt(lower) == c && pw.charAt(upper) != c) || (pw.charAt(
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
      // println(pwEntry)
    }

    correct
  }

  def checkPwEntriesV2(entries: List[String]): Int = {
    var correct = 0
    for (pwEntry <- entries if checkPolicy2(pwEntry)) {
      correct += 1
      // println(pwEntry)
    }

    correct
  }
}
