/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020.puzzle3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc2020.Puzzle;

import java.util.List;

public class Puzzle3 extends Puzzle {

  private static final Logger logger = LoggerFactory.getLogger(Puzzle3.class);
  private static final char SQUARE = '.';
  private static final char TREE = '#';

  private final Slope slope11 = new Slope(1, 1);
  private final Slope slope31 = new Slope(1, 3);
  private final Slope slope51 = new Slope(1, 5);
  private final Slope slope71 = new Slope(1, 7);
  private final Slope slope12 = new Slope(2, 1);
  private final List<Slope> slopes = List.of(slope11, slope31, slope51, slope71, slope12);

  public Puzzle3(String inputFile) {
    super(inputFile);
  }

  @Override
  public String answer1(List<String> input) {
    return String.valueOf(slide(input, slope31));
  }

  private int slide(List<String> input, Slope slope) {
    int line = 0;
    int pos = 0;
    int trees = 0;
    while (line + slope.getMoveDown() <= input.size() - 1) {
      trees += move(input, line, pos, slope);
      line += slope.getMoveDown();
      pos += slope.getMoveRight();
    }
    logger.debug("checking slope " + slope + " --> " + trees);
    return trees;
  }

  @Override
  public String answer2(List<String> input) {
    int trees = 1;
    for (Slope slope : slopes) {
      trees *= slide(input, slope);
    }
    return String.valueOf(trees);
  }

  int move(List<String> map, int startLine, int startPos, Slope slope) {
    String line = map.get(startLine + slope.getMoveDown());
    int newPosition = (startPos + slope.getMoveRight()) % (line.length());
    char position = line.charAt(newPosition);
    return position == TREE ? 1 : 0;
  }
}
