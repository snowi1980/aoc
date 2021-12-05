package org.snowi.aoc2020.puzzle4;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Getter
public class Person {

    private static final String BIRTH_YEAR = "byr";
    private static final String ISSUE_YEAR = "iyr";
    private static final String EXPIRATION_YEAR = "eyr";
    private static final String HEIGHT = "hgt";
    private static final String HAIR_COLOR = "hcl";
    private static final String EYE_COLOR = "ecl";
    private static final String PASSPORT_ID = "pid";
    private static final String COUNTRY_ID = "cid";

    private String birthYear;
    private String issueYear;
    private String expirationYear;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;

    public static Person toPerson(String definition) {
        String[] attributes = definition.split(" ");
        PersonBuilder builder = Person.builder();
        for (String attribute : attributes) {
            String[] keyValues = attribute.split(":");
            final String value = keyValues[1];
            switch (keyValues[0]) {
                case BIRTH_YEAR:
                    builder.birthYear(value);
                    break;
                case ISSUE_YEAR:
                    builder.issueYear(value);
                    break;
                case EXPIRATION_YEAR:
                    builder.expirationYear(value);
                    break;
                case HEIGHT:
                    builder.height(value);
                    break;
                case HAIR_COLOR:
                    builder.hairColor(value);
                    break;
                case EYE_COLOR:
                    builder.eyeColor(value);
                    break;
                case PASSPORT_ID:
                    builder.passportId(value);
                    break;
                case COUNTRY_ID:
                    builder.countryId(value);
                    break;
            }
        }

        return builder.build();
    }

}
