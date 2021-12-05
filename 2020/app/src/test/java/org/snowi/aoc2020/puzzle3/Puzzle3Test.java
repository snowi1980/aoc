/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020.puzzle3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Puzzle3Test {

  private Puzzle3 cut;
  private List<String> map;
  private Slope slope13 = Slope.builder().moveRight(3).moveDown(1).build();
  private Slope slope21 = Slope.builder().moveRight(1).moveDown(2).build();

  @BeforeEach
  public void setUp() {
    cut = new Puzzle3("puzzle3/testInput.txt");
    map = cut.getInput();
  }

  @Test
  void testAnswer1() {
    assertThat(cut.answer1(cut.getInput())).isEqualTo("7");
  }

  @Test
  void testAnswer2() {
    assertThat(cut.answer2(cut.getInput())).isEqualTo("336");
  }

  @Test
  void testMove13() {
    assertThat(cut.move(map, 0, 0, slope13)).isEqualTo(0);
    assertThat(cut.move(map, 1, 3, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 2, 6, slope13)).isEqualTo(0);
    assertThat(cut.move(map, 3, 9, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 4, 12, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 5, 15, slope13)).isEqualTo(0);
    assertThat(cut.move(map, 6, 18, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 7, 21, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 8, 24, slope13)).isEqualTo(1);
    assertThat(cut.move(map, 9, 27, slope13)).isEqualTo(1);
  }

  @Test
  void testMove21() {
    assertThat(cut.move(map, 0, 0, slope21)).isEqualTo(1);
    assertThat(cut.move(map, 2, 1, slope21)).isEqualTo(0);
    assertThat(cut.move(map, 4, 2, slope21)).isEqualTo(1);
    assertThat(cut.move(map, 6, 3, slope21)).isEqualTo(0);
    assertThat(cut.move(map, 8, 4, slope21)).isEqualTo(0);
  }
}
