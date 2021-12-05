package org.snowi.aoc2020.puzzle4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowi.aoc2020.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Puzzle4 extends Puzzle {

    private static final Logger logger = LoggerFactory.getLogger(Puzzle4.class);

    public Puzzle4(String inputFile) {
        super(inputFile);
    }

    @Override
    public String answer1(List<String> input) {
        return null;
    }

    @Override
    public String answer2(List<String> input) {
        return null;
    }

    List<Person> getPersons(List<String> input) {
        List<Person> persons = new ArrayList<>();
        Person.PersonBuilder builder = Person.builder();
        Map<String, String> personAttributes = new HashMap<>();
        String infos = "";
        for (int i = 0; i < input.size(); i++) {
            infos = String.join(" ", infos, input.get(i));
            if (isNextPerson(input.get(i))) {
                persons.add(builder.build());
                builder = Person.builder();
                personAttributes = Arrays.stream(infos.split(" "))
                    .map(s -> s.split(":"))
                    .collect(Collectors.toMap(s -> s[0], s -> s[1]));
                infos = "";
            }


        }
        persons.add(builder.build());
        return persons;
    }

    private boolean isNextPerson(String line) {
        return line.isEmpty();
    }
}
