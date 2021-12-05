/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2021.puzzle1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc.core.Args;
import org.snowi.aoc.core.Puzzle;

import java.util.List;

public class Puzzle1 extends Puzzle {

  private static Logger logger = LoggerFactory.getLogger(Puzzle1.class);

  public Puzzle1(String inputFile) {
    super(inputFile);
  }

  @Override
  public String answer1(List<String> input) {
    int[] measurements = this.getInputAsInt();
    return getIncreased(measurements);
  }

  private String getIncreased(int[] measurements) {
    int increased = 0;
    for (int i = 1; i < measurements.length; i++) {
      if (depthIncreased(measurements, i)) {
        increased++;
      }
    }
    return String.valueOf(increased);
  }

  @Override
  public String answer2(List<String> input) {
    int[] measurements = createMeasurementWindows(this.getInputAsInt(), 3);
    return getIncreased(measurements);
  }

  int[] createMeasurementWindows(int[] measurements, int windowSize) {
    final int measurementWindowsSize = measurements.length - windowSize + 1;
    int[] measurementWindows = new int[measurementWindowsSize];
    for (int i = 0; i < measurementWindowsSize; i++) {
      int measurementWindow = 0;
      String output = "";
      for (int j = 0; j < windowSize; j++) {
        output += measurements[i + j] + " + ";
        measurementWindow += measurements[i + j];
      }
      measurementWindows[i] = measurementWindow;
      logger.debug("{} = {}", output, measurementWindow);
    }
    return measurementWindows;
  }

  boolean depthIncreased(int[] measurements, int position) {
    checkParameters(measurements, position);
    int currentDepth = measurements[position];
    int previousDepth = measurements[position - 1];

    return currentDepth > previousDepth;
  }

  private void checkParameters(int[] measurements, int position) {
    Args.checkNotNull(measurements, "list of measurements must not be null");
    Args.checkTrue(position >= 1, "defined measurement position is below 1");
    Args.checkTrue(position < measurements.length, "defined measurement position is out of bounds");
  }
}
