/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020.puzzle1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc2020.Puzzle;

import java.util.List;

public class Puzzle1 extends Puzzle {

  private static Logger logger = LoggerFactory.getLogger(Puzzle1.class);

  public Puzzle1(String inputFile) {
    super(inputFile);
  }

  @Override
  public String answer1(List<String> inputFile) {

    int[] expenseReport = toIntArray(inputFile);

    for (int i = 0; i < expenseReport.length; i++) {
      int x = expenseReport[i];
      for (int j = 0; j < expenseReport.length; j++) {
        int y = expenseReport[j];
        logger.debug(" {} + {} = {}", x, y, x + y);
        if (x + y == 2020) {
          return String.valueOf(x * y);
        }
      }
    }
    return "n.a";
  }

  private int[] toIntArray(List<String> inputFile) {
    return inputFile.stream().mapToInt(Integer::parseInt).toArray();
  }

  @Override
  public String answer2(List<String> inputFile) {
    int[] expenseReport = toIntArray(inputFile);

    for (int i = 0; i < expenseReport.length; i++) {
      int x = expenseReport[i];
      for (int j = 0; j < expenseReport.length; j++) {
        int y = expenseReport[j];

        if (x + y < 2020) {
          for (int k = 0; k < expenseReport.length; k++) {
            int z = expenseReport[k];
            logger.debug(" {} + {}  + {} = {}", x, y, z, x + y + z);
            if (x + y + z == 2020) {
              return String.valueOf(x * y * z);
            }
          }
        }
      }
    }
    return "n.a";
  }
}
