/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2021.puzzle1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class Puzzle1Test {

  @Test
  void answer1() {
    Puzzle1 cut = TestSupport.puzzle1;
    assertThat(cut.answer1(cut.getInput())).isEqualTo("7");
  }

  @Test
  void answer2() {
    Puzzle1 cut = TestSupport.puzzle1;
    assertThat(cut.answer2(cut.getInput())).isEqualTo("5");
  }

  @Test
  void testCreateMeasurementWindows() {
    int[] expected = {607, 618, 618, 617, 647, 716, 769, 792};
    Puzzle1 cut = TestSupport.puzzle1;
    assertThat(cut.createMeasurementWindows(cut.getInputAsInt(), 3)).containsExactly(expected);
  }

  @Test
  void testIncreased() {
    Puzzle1 cut = TestSupport.puzzle1;
    int[] measurements = cut.getInputAsInt();
    assertThat(cut.depthIncreased(measurements, 1)).isTrue();
    assertThat(cut.depthIncreased(measurements, 4)).isFalse();
  }

  @Test
  void testIncreasedInvalidInput() {
    Puzzle1 cut = TestSupport.puzzle1;
    int[] measurements = {1, 2};
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> cut.depthIncreased(null, 1));

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> cut.depthIncreased(new int[0], 1));

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> cut.depthIncreased(measurements, 0));

    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> cut.depthIncreased(measurements, measurements.length + 1));
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
