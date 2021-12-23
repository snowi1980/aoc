package org.snowi.aoc2021.puzzle3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc.core.Args;
import org.snowi.aoc.core.Puzzle;

import java.util.List;

public class Puzzle3 extends Puzzle {

  private static final Logger logger = LoggerFactory.getLogger(Puzzle3.class);
  int[] bitValues = new int[5];
  int bits = 5;

  public Puzzle3(String inputFile) {
    super(inputFile);
  }

  @Override
  public String answer1(List<String> input) {
    bits = input.get(0).length();
    bitValues = new int[bits];
    input.forEach(this::countOneBits);

    return String.valueOf(getConsumption(input.size()));
  }

  @Override
  public String answer2(List<String> input) {
    bits = input.get(0).length();
    bitValues = new int[bits];

    for (int i = 0; i < bitValues.length; i++){

    }

    return null;

  }


  void countOneBits(String reportLine) {
    Args.checkNotBlank(reportLine, "Report line must not be empty");
    Args.checkTrue(reportLine.length() == bits, "Report line has wrong length");

    for (int i = 0; i < bitValues.length; i++) {
      int val = reportLine.charAt(i) - '0';
      bitValues[i] += val;
    }
  }

  int getGammaRate(int numValues) {
    StringBuilder gammaRate = new StringBuilder();
    for (int i = 0; i < bitValues.length; i++) {
      gammaRate.append(getMostCommonBit(i, numValues));
    }
    final int gammaRateDec = Integer.parseInt(gammaRate.toString(), 2);
    logger.debug("gamma rate {} -> {}", gammaRate, gammaRateDec);
    return gammaRateDec;
  }

  int getEpsilonRate(int numValues) {
    StringBuilder epsilonRate = new StringBuilder();
    for (int i = 0; i < bitValues.length; i++) {
      epsilonRate.append(getLeastCommonBit(i, numValues));
    }
    final int epsilonRateDec = Integer.parseInt(epsilonRate.toString(), 2);
    logger.debug("epsilon rate {} -> {}", epsilonRate, epsilonRateDec);
    return epsilonRateDec;
  }

  int getConsumption(int numValues) {
    return getGammaRate(numValues) * getEpsilonRate(numValues);
  }

  char getLeastCommonBit(int bitPosition, int numValues) {
    validateCommonBitParameters(bitPosition, numValues);
    final int amountOfOneBits = bitValues[bitPosition];
    final int threshold = numValues / 2;
    final char leastCommonBit = amountOfOneBits < threshold ? '1' : '0';
    logger.debug(
        "least common bit at position {} amountOfOneBits  {} and threshold {}  --> {}",
        bitPosition,
        amountOfOneBits,
        threshold,
        leastCommonBit);
    return leastCommonBit;
  }

  char getMostCommonBit(int bitPosition, int numValues) {
    validateCommonBitParameters(bitPosition, numValues);

    final int amountOneBits = bitValues[bitPosition];
    final int threshold = numValues / 2;
    final char mostCommonBit = amountOneBits >= threshold ? '1' : '0';
    logger.debug(
        "most common bit at position {} amountOneBits  {} and threshold {}  --> {}",
        bitPosition,
        amountOneBits,
        threshold,
        mostCommonBit);
    return mostCommonBit;
  }

  private void validateCommonBitParameters(int bitPosition, int numValues) {
    Args.checkTrue(
        bitPosition < bitValues.length,
        "bitPosition {} higher then {}",
        bitPosition,
        bitValues.length);
    Args.checkTrue(bitPosition >= 0, "bitPosition {} below 0", bitPosition);
    Args.checkTrue(numValues >= 0, "numValues {} below 0", numValues);
  }

  boolean extractValueAtPosition(int intRepresentation, int position) {
    return ((intRepresentation) & (1 << (position - 1))) != 0;
  }
}
