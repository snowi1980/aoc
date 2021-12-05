/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2021.puzzle2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class Puzzle2Test {

  @Test
  void testAnswer1() {
    Puzzle2 puzzle2 = TestSupport.puzzle2;
    assertThat(puzzle2.answer1(puzzle2.getInput())).isEqualTo("150");
  }

  @Test
  void testCommands() {
    String[] commands = {"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"};
    Puzzle2.Position pos = Puzzle2.createPosition();
    for (String command : commands) {
      pos.move(command);
    }
    assertThat(pos.getDepth()).isEqualTo(10);
    assertThat(pos.getHorizontal()).isEqualTo(15);
    assertThat(pos.finalPosition()).isEqualTo(150);
  }

  @Test
  void testForward() {
    Puzzle2.Position pos = Puzzle2.createPosition();
    pos.forward(2);
    assertThat(pos.getHorizontal()).isEqualTo(2);
    assertThat(pos.getDepth()).isEqualTo(0);
  }

  @Test
  void testUp() {
    Puzzle2.Position pos = Puzzle2.createPosition();
    pos.down(4);
    pos.up(2);
    assertThat(pos.getHorizontal()).isEqualTo(0);
    assertThat(pos.getDepth()).isEqualTo(2);
  }

  @Test
  void testDown() {
    Puzzle2.Position pos = Puzzle2.createPosition();
    pos.down(2);
    assertThat(pos.getHorizontal()).isEqualTo(0);
    assertThat(pos.getDepth()).isEqualTo(2);
  }

  @ParameterizedTest
  @ValueSource(strings = {"forward -1", "epps 3", "up down"})
  @NullAndEmptySource
  void testInvalidCommands(String command) {
    Puzzle2.Position pos = Puzzle2.createPosition();
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              pos.move(command);
            });
  }
}
