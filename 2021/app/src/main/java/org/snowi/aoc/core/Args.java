/* Copyright: (C) stefan.devops@gmail.com 2021, all rights reserved */
package org.snowi.aoc.core;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class Args {

  /**
   * Checks if a boolean expression is true.
   *
   * @param value boolean expression to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the expression is false
   */
  public static void checkTrue(boolean value, String message, Object... args) {
    if (!value) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a given value is not null.
   *
   * @param value value to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the value is null
   */
  public static void checkNotNull(Object value, String message, Object... args) {
    if (value == null) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a given value is not null and not blank (empty or whitespace only).
   *
   * @param value value to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the value is null or blank
   */
  public static void checkNotBlank(String value, String message, Object... args) {
    if (value == null || value.isBlank()) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if the length of a given <code>String</code> is not greater than a maximum length. Null
   * values are allowed.
   *
   * @param value value to be checked
   * @param maxLength maximum length for the given value
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the length of the given <code>value</code> is greater than
   *     <code>maxLength</code>
   */
  public static void checkMaxLength(String value, int maxLength, String message, Object... args) {
    if (value != null && value.length() > maxLength) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if the length of a given <code>String</code> is not less than a minimum length. Null
   * values are allowed.
   *
   * @param value value to be checked
   * @param minLength minimum length for the given value
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the length of the given <code>value</code> is less than
   *     <code>minLength</code>
   */
  public static void checkMinLength(String value, int minLength, String message, Object... args) {
    if (value != null && value.length() < minLength) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a given <code>String</code> matches a regular expression. Null values are allowed.
   *
   * @param value value to be checked
   * @param regex the regular expression to check the value against
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the given <code>value</code> does not match the regular
   *     expression
   */
  public static void checkPatternMatch(String value, String regex, String message, Object... args) {
    if (value != null && !Pattern.matches(regex, value)) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a byte array is not null and not empty.
   *
   * @param array value to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the array is null or empty
   */
  public static void checkArrayNotEmpty(byte[] array, String message, Object... args) {
    if (args == null || args.length == 0) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a List is not null and not empty.
   *
   * @param list value to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the array is null or empty
   */
  public static void checkListNotEmpty(List<?> list, String message, Object... args) {
    if (list == null || list.isEmpty()) {
      raiseIllegalArgument(message, args);
    }
  }

  /**
   * Checks if a Map is not null and not empty.
   *
   * @param map value to be checked
   * @param message error message
   * @param args additional arguments to be sent with the exception
   * @throws IllegalArgumentException if the array is null or empty
   */
  public static void checkMapNotEmpty(Map<?, ?> map, String message, Object... args) {
    if (map == null || map.isEmpty()) {
      raiseIllegalArgument(message, args);
    }
  }

  private static void raiseIllegalArgument(String message, Object... args) {
    String errorMessage = toErrorMessage(message, args);
    throw new IllegalArgumentException(errorMessage);
  }

  private static String toErrorMessage(String message, Object... args) {
    return message != null ? String.format(message, args) : null;
  }

  private Args() {}
}
