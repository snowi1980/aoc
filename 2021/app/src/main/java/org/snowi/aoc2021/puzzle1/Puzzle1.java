package org.snowi.aoc2021.puzzle1;

import org.snowi.aoc.core.Args;
import org.snowi.aoc.core.Puzzle;

import java.util.List;

public class Puzzle1 extends Puzzle {


    public Puzzle1(String inputFile) {
        super(inputFile);
    }

    @Override
    public String answer1(List<String> input) {
        int[] measurements = this.getInputAsInt();
        int increased = 0;
        for (int i = 1; i < measurements.length; i++) {
            if(depthIncreased(measurements, i)){
                increased++;
            }
        }
        return String.valueOf(increased);
    }

    @Override
    public String answer2(List<String> input) {
        return null;
    }

    boolean depthIncreased(int[] measurements, int position){
        checkParameters(measurements, position);
        int currentDepth = measurements[position];
        int previousDepth = measurements[position -1];

        return currentDepth > previousDepth;
    }

    private void checkParameters(int[] measurements, int position) {
        Args.checkNotNull(measurements, "list of measurements must not be null");
        Args.checkTrue(position >= 1, "defined measurement position is below 1");
        Args.checkTrue(position < measurements.length, "defined measurement position is out of bounds");
    }
}
