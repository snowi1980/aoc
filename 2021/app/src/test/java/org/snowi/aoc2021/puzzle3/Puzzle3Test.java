package org.snowi.aoc2021.puzzle3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Puzzle3Test {

  static Stream<Arguments> provideValuesForExtractValueAtPosition() {
    // 10110 = 22 decimal
    return Stream.of(
        Arguments.of(22, 1, false),
        Arguments.of(22, 2, true),
        Arguments.of(22, 3, true),
        Arguments.of(22, 4, false),
        Arguments.of(22, 5, true));
  }

  @Test
  void testAddBitvalues() {
    Puzzle3 cut = TestSupport.puzzle3;
    cut.countOneBits("01010");
    cut.countOneBits("01010");
    assertThat(cut.getLeastCommonBit(0, 2)).isEqualTo(1);
    assertThat(cut.getLeastCommonBit(1, 2)).isEqualTo(0);
    assertThat(cut.getLeastCommonBit(2, 2)).isEqualTo(1);
    assertThat(cut.getLeastCommonBit(3, 2)).isEqualTo(0);
    assertThat(cut.getLeastCommonBit(4, 2)).isEqualTo(1);

    assertThat(cut.getMostCommonBit(0, 2)).isEqualTo(0);
    assertThat(cut.getMostCommonBit(1, 2)).isEqualTo(1);
    assertThat(cut.getMostCommonBit(2, 2)).isEqualTo(0);
    assertThat(cut.getMostCommonBit(3, 2)).isEqualTo(1);
    assertThat(cut.getMostCommonBit(4, 2)).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("provideValuesForExtractValueAtPosition")
  void testExtractValueAtPosition(int value, int postion, boolean extractedValue) {
    Puzzle3 cut = TestSupport.puzzle3;
    assertThat(cut.extractValueAtPosition(value, postion)).isEqualTo(extractedValue);
  }

  @Test
  void testGetLeastCommonBit() {
    Puzzle3 cut = TestSupport.puzzle3;
    List<String> reportLines = cut.getInput();
    cut.answer1(reportLines);
    assertThat(cut.getLeastCommonBit(0, reportLines.size())).isEqualTo(0);
    assertThat(cut.getLeastCommonBit(1, reportLines.size())).isEqualTo(1);
    assertThat(cut.getLeastCommonBit(2, reportLines.size())).isEqualTo(0);
    assertThat(cut.getLeastCommonBit(3, reportLines.size())).isEqualTo(0);
    assertThat(cut.getLeastCommonBit(4, reportLines.size())).isEqualTo(1);
  }

  @Test
  void testGetMostCommonBit() {
    Puzzle3 cut = TestSupport.puzzle3;
    List<String> reportLines = cut.getInput();
    cut.answer1(reportLines);
    assertThat(cut.getMostCommonBit(0, reportLines.size())).isEqualTo(1);
    assertThat(cut.getMostCommonBit(1, reportLines.size())).isEqualTo(0);
    assertThat(cut.getMostCommonBit(2, reportLines.size())).isEqualTo(1);
    assertThat(cut.getMostCommonBit(3, reportLines.size())).isEqualTo(1);
    assertThat(cut.getMostCommonBit(4, reportLines.size())).isEqualTo(0);
  }

  @Test
  void testGetGammaRate() {
    Puzzle3 cut = TestSupport.puzzle3;
    List<String> reportLines = cut.getInput();
    cut.answer1(reportLines);
    assertThat(cut.getGammaRate(reportLines.size())).isEqualTo(22);
  }

  @Test
  void testGetEpsilonRate() {
    Puzzle3 cut = TestSupport.puzzle3;
    List<String> reportLines = cut.getInput();
    cut.answer1(reportLines);
    assertThat(cut.getEpsilonRate(reportLines.size())).isEqualTo(9);

  }

    @Test
  void testAnswer1() {
    Puzzle3 cut = TestSupport.puzzle3;
    List<String> reportLines = cut.getInput();
    cut.answer1(reportLines);
    assertThat(cut.getConsumption(reportLines.size())).isEqualTo(198);
  }
}
