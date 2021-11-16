package org.snowi.aoc2020.puzzle3

object Puzzle3 {

  val square = '.'
  val tree = '#'

  def main(args: Array[String]): Unit = {
    answer()
  }

  def answer(): Unit = {
    val input = readMap("puzzle3/input.txt")
    println()
    println("--------------- Puzzle 03 ---------------")
    println("Result puzzle 3 part 1: " + answer1(input))
    // println("Result puzzle 3 part 2: " + checkPwEntriesV2(input))
    println()
  }

  def answer1(map: List[String]): Int = {
    var level = 0
    var trees = 0
    while (level < map.length -1){
      trees += move(map, level, level * 3, 3, 1)
      level += 1
    }
    trees
  }

  def move(
      map: List[String],
      startLine: Int,
      startPos: Int,
      moveRight: Int,
      moveDown: Int
  ): Int = {
    val line = map(startLine + moveDown)
    val newPosition = (startPos + moveRight) % (line.length)
    println("line: " + (startLine +moveDown) + "  index: " + newPosition)
    println(line.substring(0, newPosition) + "P" + line.substring(newPosition + 1, line.length ))
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
