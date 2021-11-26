package org.snowi.aoc2020.puzzle2;

import org.snowi.aoc2020.Puzzle;

import java.util.List;

public class Puzzle2 extends Puzzle {
    private static final int IDX_LOWER_TOKEN = 0;
    private static final int IDX_UPPER_TOKEN = 1;
    private static final int IDX_CHAR_TOKEN = 2;
    private static final int IDX_PW_TOKEN = 3;

    public Puzzle2(String inputFile) {
        super(inputFile);
    }

    @Override
    public String answer1(List<String> input) {
        int correct = 0;
        for (String password : input){
            if(checkPolicy1(password)){
                correct++;
            }
        }
        return String.valueOf(correct);
    }

    @Override
    public String answer2(List<String> input) {
        int correct = 0;
        for (String password : input){
            if(checkPolicy2(password)){
                correct++;
            }
        }
        return String.valueOf(correct);
    }

    boolean checkPolicy1(String pwEntry) {
        String[] tokens = pwEntry.replace("-", " ").split(" ");
        String pw = tokens[IDX_PW_TOKEN];
        int lower = Integer.parseInt(tokens[IDX_LOWER_TOKEN]);
        int upper = Integer.parseInt(tokens[IDX_UPPER_TOKEN]);
        char c = tokens[IDX_CHAR_TOKEN].replace(":", "").charAt(0);
        int i = 0;
        int matches = 0;

        while (i < pw.length()) {
            if (pw.charAt(i) == c) {
                matches += 1;
            }
            i += 1;
        }
        return (lower <= matches) && (matches <= upper);
    }

    boolean checkPolicy2(String pwEntry) {
        String[] tokens = pwEntry.replace("-", " ").split(" ");
        String pw = tokens[IDX_PW_TOKEN];
        int lower = Integer.parseInt(tokens[IDX_LOWER_TOKEN]) - 1;
        int upper = Integer.parseInt(tokens[IDX_UPPER_TOKEN]) - 1;
        char c = tokens[IDX_CHAR_TOKEN].replace(":", "").charAt(0);


        return ((pw.charAt(lower) == c && pw.charAt(upper) != c) || (pw.charAt(
            lower
        ) != c && pw.charAt(upper) == c));
    }


}
