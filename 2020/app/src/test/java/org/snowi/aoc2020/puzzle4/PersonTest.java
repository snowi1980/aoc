package org.snowi.aoc2020.puzzle4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {


    @Test
    void toPersonWithAllAttributes() {
        Person testPerson = Person.toPerson("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd " +
            "byr:1937 iyr:2017 cid:147 hgt:183cm");
        assertThat(testPerson.getEyeColor()).isEqualTo("gry");
        assertThat(testPerson.getPassportId()).isEqualTo("860033327");
        assertThat(testPerson.getExpirationYear()).isEqualTo("2020");
        assertThat(testPerson.getBirthYear()).isEqualTo("1937");
        assertThat(testPerson.getIssueYear()).isEqualTo("2017");
        assertThat(testPerson.getCountryId()).isEqualTo("147");
        assertThat(testPerson.getHeight()).isEqualTo("183cm");
    }
}