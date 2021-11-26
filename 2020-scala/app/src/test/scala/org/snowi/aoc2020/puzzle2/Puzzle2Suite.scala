/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle2

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Puzzle2Suite extends AnyFunSuite {

  var inputV1 = List(
    "1-3 a: abcde",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc",
    "15-19 k: kkkkkkkkkkkkzkkkkkkk"
  )

  var inputV2 = List(
    "1-3 a: abcde",
    "1-3 a: cbade",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc",
    "15-19 k: kkkkkkkkkkkkzkkkkkkk"
  )

  test("Check file") {
    // assert(Puzzle1.answer(expenseReport) == 514579)
  }

  test("valid PW for policy v1") {
    assert(Puzzle2.checkPolicy1("1-3 a: abcde"))
    assert(Puzzle2.checkPolicy1("2-9 c: ccccccccc"))
    assert(Puzzle2.checkPolicy1("15-19 k: kkkkkkkkkkkkzkkkkkkk"))
  }

  test("valid PW for policy v2") {
    assert(Puzzle2.checkPolicy2("1-3 a: abcde"))
    assert(Puzzle2.checkPolicy2("1-3 a: cbade"))

  }

  test("corrupted PW") {
    assert(!Puzzle2.checkPolicy1("1-3 b: cdefg"))
  }



  test("corrupted PW for policy v2") {
    assert(!Puzzle2.checkPolicy2("1-3 b: cdefg"))
    assert(!Puzzle2.checkPolicy2("2-9 c: ccccccccc"))
    assert(!Puzzle2.checkPolicy2("15-19 k: kkkkkkkkkkkkzkkkkkkk"))
  }

  test("check entries V1") {
    assert(Puzzle2.checkPwEntries(inputV1) == 3)
  }

  test("check entries v2") {
    assert(Puzzle2.checkPwEntriesV2(inputV2) == 2)
  }
}
