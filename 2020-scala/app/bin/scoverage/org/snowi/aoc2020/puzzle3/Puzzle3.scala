/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle3

object Puzzle3 {

  val square = '.'
  val tree = '#'
  val slope11 = new Slope(1, 1)
  val slope31 = new Slope(3, 1)
  val slope51 = new Slope(5, 1)
  val slope71 = new Slope(7, 1)
  val slope12 = new Slope(1, 2)

  val slopes = Array(slope11, slope31, slope51, slope71, slope12)

  def main(args: Array[String]): Unit = {
//    logger.info("jjsjs")
    answer()
  }

  def answer(): Unit = {
    val input = readMap("puzzle3/input.txt")
    println()
    println("--------------- Puzzle 03 ---------------")
    println("Result puzzle 3 part 1: " + answer1(input, slope31))
    println("Result puzzle 3 part 2: " + answer2(input, slopes))
    println()
  }

  def answer1(map: List[String], slope: Slope): Int = {

    var line = 0
    var pos = 0
    var trees = 0
    while (line + slope.moveDown <= map.length - 1) {
      trees += move(map, line, pos, slope)
      line += slope.moveDown
      pos += slope.moveRight
    }
    println("checking slope " + slope + " --> " + trees)
    trees
  }

  def answer2(map: List[String], slopes: Array[Slope]): Int = {
    var result = 1
    for (slope <- slopes) {
      result *= answer1(map, slope)
    }
    result
  }

  def move(
      map: List[String],
      startLine: Int,
      startPos: Int,
      slope: Slope
  ): Int = {
  //  println("StartLine: " + startLine + "   startPos: " + startPos)
    val line = map(startLine + slope.moveDown)
    val newPosition = (startPos + slope.moveRight) % (line.length)
    val position = line.charAt(newPosition)
    if (position == tree) {
      1
    } else {
      0
    }

  }

  def readMap(filename: String): List[String] = {
    val bufferedSource = io.Source.fromResource(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

}
