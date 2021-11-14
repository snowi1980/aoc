/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppSuite extends AnyFunSuite {
  test("App has a greeting") {
    assert(App.greeting() != null)
  }
}
