/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020.puzzle2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class Puzzle2Test {

  private Puzzle2 cut;

  String[] inputV1 = {
    "1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc", "15-19 k: kkkkkkkkkkkkzkkkkkkk"
  };

  String[] inputV2 = {
    "1-3 a: abcde",
    "1-3 a: cbade",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc",
    "15-19 k: kkkkkkkkkkkkzkkkkkkk"
  };

  @BeforeEach
  void setUp() {
    cut = new Puzzle2("file");
  }

  @Test
  void testAnswer1() {
    assertThat(cut.answer1(Arrays.asList(inputV1))).isEqualTo("3");
  }

  @Test
  void testAnswer2() {
    assertThat(cut.answer1(Arrays.asList(inputV2))).isEqualTo("4");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1-3 a: abcde", "2-9 c: ccccccccc", "15-19 k: kkkkkkkkkkkkzkkkkkkk"})
  void checkPolicy1ValidPassword(String pwEntry) {
    assertThat(cut.checkPolicy1(pwEntry)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"1-3 b: cdefg"})
  void checkPolicy1CorruptedPassword(String pwEntry) {
    assertThat(cut.checkPolicy1(pwEntry)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"1-3 a: abcde", "1-3 a: cbade"})
  void checkPolicy2ValidPassword(String pwEntry) {
    assertThat(cut.checkPolicy2(pwEntry)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"1-3 b: cdefg", "2-9 c: ccccccccc", "15-19 k: kkkkkkkkkkkkzkkkkkkk"})
  void checkPolicy2CorruptedPassword(String pwEntry) {
    assertThat(cut.checkPolicy2(pwEntry)).isFalse();
  }
}
