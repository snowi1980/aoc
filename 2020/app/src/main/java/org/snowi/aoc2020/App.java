/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2020;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger logger= LoggerFactory.getLogger(App.class);

  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    logger.info(new App().getGreeting());
  }
}
