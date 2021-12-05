/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public abstract class Puzzle {

  private static final Logger logger = LoggerFactory.getLogger(Puzzle.class);

  final String inputFile;
  private List<String> input;

  public Puzzle(String inputFile) {
    this.inputFile = inputFile;
  }

  public void answer() {
    input = readInput(inputFile);
    logger.info("");
    logger.info("--------------- {} ---------------", this.getClass().getSimpleName());
    logger.info("Result part 1: {}", answer1(input));
    logger.info("Result part 2: {}", answer2(input));
    logger.info("");
  }

  private List<String> readInput(String inputFile) {
    try {
      File file = getFile(inputFile);
      return Files.readAllLines(file.toPath());

    } catch (IOException e) {
      throw new IllegalArgumentException("Error reading input file " + inputFile, e);
    }
  }

  public List<String> getInput() {
    if (input == null) {
      input = readInput(this.inputFile);
    }
    return input;
  }

  public int[] getInputAsInt() {
    String[] temp = new String[getInput().size()];
    return Arrays.stream(getInput().toArray(temp))
        .mapToInt(value -> Integer.parseInt(value, 10))
        .toArray();
  }

  public abstract String answer1(List<String> input);

  public abstract String answer2(List<String> input);

  protected String getInputFile() {
    return inputFile;
  }

  private File getFile(String fileName) throws IOException {
    Args.checkNotBlank(fileName, "provided fileName is empty");
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);

    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
