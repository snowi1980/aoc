/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc2020.puzzle1.Puzzle1;

import java.util.ArrayList;
import java.util.List;

public class App {

  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    List<Puzzle> puzzles = new ArrayList<>();
    puzzles.add(new Puzzle1("puzzle1/input.txt"));

    for (Puzzle puzzle : puzzles) {
      puzzle.answer();
    }
  }
}
