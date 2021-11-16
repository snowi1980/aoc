/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020

import org.snowi.aoc2020.puzzle1.Puzzle1
import org.snowi.aoc2020.puzzle2.Puzzle2

object App {
  def main(args: Array[String]): Unit = {
    answers()
  }

  def answers(): Unit = {
    Puzzle1.answer()
    Puzzle2.answer()
  }

}
