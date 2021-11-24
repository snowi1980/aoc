/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle1

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Puzzle1Suite extends AnyFunSuite {

  var expenseReport = Array(1721, 979, 366, 299, 675, 1456)

  test("answer puzzle 1 part 1") {
    assert(Puzzle1.answer1(expenseReport) == 514579)
  }

  test("answer puzzle 1 part 2") {
    assert(Puzzle1.answer2(expenseReport) == 241861950)
  }
}
