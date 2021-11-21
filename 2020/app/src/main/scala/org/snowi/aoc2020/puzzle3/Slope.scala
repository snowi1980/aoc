/* (C) stefan.devops@gmail.com 2021 */
package org.snowi.aoc2020.puzzle3

class Slope(val moveRight: Int, val moveDown: Int) {
  override def toString: String =
    s"($moveRight, $moveDown)"
}
