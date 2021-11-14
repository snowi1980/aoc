/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle2

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Puzzle2Suite extends AnyFunSuite {

  var input = List(
    "1-3 a: abcde",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc",
    "15-19 k: kkkkkkkkkkkkzkkkkkkk"
  )

  test("Check file") {
    // assert(Puzzle1.answer(expenseReport) == 514579)
  }

  test("valid PW") {
    assert(Puzzle2.checkPw("1-3 a: abcde"))
    assert(Puzzle2.checkPw("2-9 c: ccccccccc"))
    assert(Puzzle2.checkPw("15-19 k: kkkkkkkkkkkkzkkkkkkk"))
  }

  test("corrupted PW") {
    assert(!Puzzle2.checkPw("1-3 b: cdefg"))
  }

  test("check entries") {
    assert(Puzzle2.checkPwEntries(input) == 3)
  }
}
