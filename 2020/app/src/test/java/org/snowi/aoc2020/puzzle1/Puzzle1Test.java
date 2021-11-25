/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020.puzzle1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Puzzle1Test {

  private Puzzle1 cut;
  private List<String> input;

  @BeforeEach
  void setUp() {
    cut = new Puzzle1("puzzle1/inputTest.txt");
    input = cut.getInput();
  }

  @Test
  void answer1() {
    assertThat(cut.answer1(input)).isEqualTo("514579");
  }

  @Test
  void answer2() {
    assertThat(cut.answer2(input)).isEqualTo("241861950");
  }

  @Test
  void invalidInputFile() {
    Puzzle1 p = new Puzzle1("blah");
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              p.getInput();
            })
        .withMessageContaining("file is not found!");
  }
}
