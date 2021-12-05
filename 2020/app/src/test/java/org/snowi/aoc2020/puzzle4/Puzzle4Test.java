package org.snowi.aoc2020.puzzle4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Puzzle4Test {

    private Puzzle4 cut;


    @BeforeEach
    void setUp() {
        cut = new Puzzle4("puzzle4/input.txt");
    }

    @Test
    void answer1() {
    }

    @Test
    void answer2() {
    }

    @Test
    void getPersons() {
        Puzzle4 puzzle = new Puzzle4("puzzle4/inputTest.txt");
        List<Person> persons = puzzle.getPersons(puzzle.getInput());
        assertThat(persons.size()).isEqualTo(4);
    }
}