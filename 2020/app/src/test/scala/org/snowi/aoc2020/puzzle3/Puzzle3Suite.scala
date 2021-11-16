package org.snowi.aoc2020.puzzle3

import org.scalatest.funsuite.AnyFunSuite
import org.snowi.aoc2020.puzzle1.Puzzle1

class Puzzle3Suite extends AnyFunSuite {

  test("testAnswer1") {
    assert(Puzzle3.answer1(Puzzle3.readMap("puzzle3/testInput.txt")) == 7)
  }

  test("test move") {
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 0, 0, 3, 1) == 0
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 1, 3, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 2, 6, 3, 1) == 0
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 3, 9, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 4, 12, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 5, 15, 3, 1) == 0
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 6, 18, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 7, 21, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 8, 24, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 9, 27, 3, 1) == 1
    )
    assert(
      Puzzle3.move(Puzzle3.readMap("puzzle3/testInput.txt"), 10, 30, 3, 1) == 1
    )
  }

}
