/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc2021.puzzle2;

import org.snowi.aoc.core.Args;
import org.snowi.aoc.core.Puzzle;

import java.util.List;

public class Puzzle2 extends Puzzle {

  public Puzzle2(String inputFile) {
    super(inputFile);
  }

  @Override
  public String answer1(List<String> input) {
    Position position = createPosition();
    input.forEach(
        command -> {
          position.move(command);
        });
    return String.valueOf(position.finalPosition());
  }

  @Override
  public String answer2(List<String> input) {
    return null;
  }

  public static class Position {
    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";

    private int horizontal;
    private int depth;

    private Position() {
      horizontal = 0;
      depth = 0;
    }

    public void move(String command) {
      Args.checkNotBlank(command, "Given command is empty");
      String[] moveInfo = command.split(" ");
      final String direction = moveInfo[0];
      final int distance = toDistance(moveInfo[1]);
      switch (direction) {
        case FORWARD:
          forward(distance);
          break;
        case DOWN:
          down(distance);
          break;
        case UP:
          up(distance);
          break;
        default:
          throw new IllegalArgumentException("Unknown command given: " + direction);
      }
    }

    private int toDistance(String distanceValue) {
      Args.checkNotBlank(distanceValue, "cannot create distance from empty String");
      return Integer.parseInt(distanceValue, 10);
    }

    public void forward(int acceleration) {
      Args.checkTrue(acceleration >= 0, "Cannot move backwards");
      horizontal = horizontal + acceleration;
    }

    public void down(int sink) {
      Args.checkTrue(sink >= 0, "Input value for sink must be >= 0");
      depth = depth + sink;
    }

    public void up(int raise) {
      Args.checkTrue(depth >= raise, "Cannot raise ship above sea level ;-P)");
      depth = depth - raise;
    }

    public int getHorizontal() {
      return horizontal;
    }

    public int getDepth() {
      return depth;
    }

    public int finalPosition() {
      return horizontal * depth;
    }

    @Override
    public String toString() {
      return "Position{" + "horizontal=" + horizontal + ", depth=" + depth + '}';
    }
  }

  static Position createPosition() {
    return new Puzzle2.Position();
  }
}
