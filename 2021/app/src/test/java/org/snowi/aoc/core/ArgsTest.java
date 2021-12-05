/* Copyright: (C) BMW AG 2021, all rights reserved */
package org.snowi.aoc.core;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ArgsTest {

    @Test
    void testCheckTrue_givenTrue() {
        Args.checkTrue(true, "Message");
    }

    @Test
    void testCheckTrue_givenFalse() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkTrue(false, "Message: %s", false);
        });

        assertThat(error.getMessage()).isEqualTo("Message: false");
    }

    @Test
    void testCheckNotNull_givenNotNull() {
        Args.checkNotNull("arg", "Message");
    }

    @Test
    void testCheckNotNull_givenNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkNotNull(null, "Message: %s %s", "Hello", "World");
        });

        assertThat(error.getMessage()).isEqualTo("Message: Hello World");
    }

    @Test
    void testCheckNotBlank_givenNotBlank() {
        Args.checkNotBlank("arg", "Message");
    }

    @Test
    void testCheckNotBlank_givenNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkNotBlank(null, "Message: %s", (String) null);
        });

        assertThat(error.getMessage()).isEqualTo("Message: null");
    }

    @Test
    void testCheckNotBlank_givenEmpty() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkNotBlank("", "Message: %s", "null or empty");
        });

        assertThat(error.getMessage()).isEqualTo("Message: null or empty");
    }

    @Test
    void testCheckNotBlank_givenSpacesOnly() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkNotBlank("   ", "Message: null or empty");
        });

        assertThat(error.getMessage()).isEqualTo("Message: null or empty");
    }

    @Test
    void checkPatternMatch_givenMatchingString() {
        Args.checkPatternMatch("1234567890", "\\d{10}", "Message");
    }

    @Test
    void checkPatternMatch_givenNull() {
        Args.checkPatternMatch(null, "\\d{10}", "Message");
    }

    @Test
    void checkPatternMatch_givenNonMatchingString() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkPatternMatch("123456789", "\\d{10}", "Message");
        });

        assertThat(error.getMessage()).isEqualTo("Message");
    }

    @Test
    void checkMaxLength_givenValidString() {
        Args.checkMaxLength("123", 4, "Message");
    }

    @Test
    void checkMaxLength_givenNull() {
        Args.checkMaxLength(null, 2, "Message");
    }

    @Test
    void checkMaxLength_givenExceedingString() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkMaxLength("123", 2, "Message");
        });

        assertThat(error.getMessage()).isEqualTo("Message");
    }

    @Test
    void checkMinLength_givenValidString() {
        Args.checkMinLength("123", 2, "Message");
    }

    @Test
    void checkMinLength_givenNull() {
        Args.checkMinLength(null, 2, "Message");
    }

    @Test
    void checkMinLength_givenInferiorLength() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkMinLength("123", 4, "Message");
        });

        assertThat(error.getMessage()).isEqualTo("Message");
    }

    @Test
    void testCheckArrayNotEmpty_givenValidArray() {
        Args.checkArrayNotEmpty("arg".getBytes(UTF_8), "Message");
    }

    @Test
    void testCheckArrayNotEmpty_givenNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkArrayNotEmpty(null, "Message: %s", (String) null);
        });

        assertThat(error.getMessage()).isEqualTo("Message: null");
    }

    @Test
    void testCheckArrayNotEmpyt_givenEmptyArray() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkArrayNotEmpty(new byte[0], "Message: %s", "null or empty");
        });

        assertThat(error.getMessage()).isEqualTo("Message: null or empty");
    }

    @Test
    void testCheckListNotEmpty_givenNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkListNotEmpty(null, "Message: %s", (String) null);
        });

        assertThat(error.getMessage()).isEqualTo("Message: null");
    }

    @Test
    void testCheckListNotEmpyt_givenEmptyArray() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkListNotEmpty(List.of(), "Message: %s", "empty");
        });

        assertThat(error.getMessage()).isEqualTo("Message: empty");
    }

    @Test
    void testCheckMapNotEmpty_givenNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkMapNotEmpty(null, "Message: %s", (String) null);
        });

        assertThat(error.getMessage()).isEqualTo("Message: null");
    }

    @Test
    void testCheckMapNotEmpyt_givenEmptyArray() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            Args.checkMapNotEmpty(Map.of(), "Message: %s", "empty");
        });

        assertThat(error.getMessage()).isEqualTo("Message: empty");
    }

}
