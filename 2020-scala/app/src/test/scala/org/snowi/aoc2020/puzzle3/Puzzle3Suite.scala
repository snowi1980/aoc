/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle3

import org.scalatest.funsuite.AnyFunSuite

class Puzzle3Suite extends AnyFunSuite {

  test("testAnswer1") {
    assert(
      Puzzle3.answer1(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        Puzzle3.slope31
      ) == 7
    )
    assert(
      Puzzle3.answer1(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        Puzzle3.slope12
      ) == 2
    )
  }

  test("testAnswer2") {
    assert(
      Puzzle3.answer2(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        Puzzle3.slopes
      ) == 336
    )
  }

  test("test move") {
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        0,
        0,
        Puzzle3.slope31
      ) == 0
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        1,
        3,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        2,
        6,
        Puzzle3.slope31
      ) == 0
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        3,
        9,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        4,
        12,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        5,
        15,
        Puzzle3.slope31
      ) == 0
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        6,
        18,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        7,
        21,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        8,
        24,
        Puzzle3.slope31
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        9,
        27,
        Puzzle3.slope31
      ) == 1
    )
  }

  test("test2 move") {
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        0,
        0,
        Puzzle3.slope12
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        2,
        1,
        Puzzle3.slope12
      ) == 0
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        4,
        2,
        Puzzle3.slope12
      ) == 1
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        6,
        3,
        Puzzle3.slope12
      ) == 0
    )
    assert(
      Puzzle3.move(
        Puzzle3.readMap("puzzle3/testInput.txt"),
        8,
        4,
        Puzzle3.slope12
      ) == 0
    )

  }

}
