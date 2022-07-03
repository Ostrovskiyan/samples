package com.aostrovskyi.samples.tasks.codewars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.
 * <p>
 * Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
 * <p>
 * Input range : 1 <= n < 4000
 * <p>
 * In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").
 * <p>
 * Examples
 * <p>
 * RomanNumerals.toRoman(1000) // should return 'M'
 * RomanNumerals.fromRoman("M") // should return 1000
 * Help
 * <p>
 * Symbol	Value
 * I	1
 * IV	4
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 */
public class RomanNumerals {

    private static final Map<String, Integer> ROMANS_TO_INT = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    private static final Map<Integer, String> INTS_TO_ROMANS = ROMANS_TO_INT.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    private static final List<Integer> CORRESPONDED_ROMAN_INTS = ROMANS_TO_INT.values().stream().sorted().toList();

    public static String toRoman(int n) {
        if (n == 0) {
            return "";
        }

        int biggestPart = 0;
        String prefix = "";
        for (int i = 0; i < CORRESPONDED_ROMAN_INTS.size(); i++) {
            int pretender = CORRESPONDED_ROMAN_INTS.get(i);
            String romanPretender = INTS_TO_ROMANS.get(pretender);
            if (pretender == n) {
                return romanPretender;
            } else if (pretender > n) {
                int prepended = 0;
                if (i > 0) {
                    if (i % 2 == 0) {
                        prepended = CORRESPONDED_ROMAN_INTS.get(i - 2);
                    } else {
                        prepended = CORRESPONDED_ROMAN_INTS.get(i - 1);
                    }
                }
                int prependedPretender = pretender - prepended;
                if (prependedPretender <= n) {
                    return INTS_TO_ROMANS.get(prepended) + romanPretender + toRoman(n - prependedPretender);
                }
            } else {
                biggestPart = pretender;
                prefix = romanPretender;
            }
        }


        return prefix + toRoman(n - biggestPart);
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            String currentRoman = romanNumeral.substring(i, i + 1);
            int currentNumber = ROMANS_TO_INT.get(currentRoman);
            if (i + 1 < romanNumeral.length()) {
                String possiblePrepended = romanNumeral.substring(i + 1, i + 2);
                Integer possibleNumberPrepended = ROMANS_TO_INT.get(possiblePrepended);
                if (possibleNumberPrepended > currentNumber) {
                    currentNumber = possibleNumberPrepended - currentNumber;
                    i++;
                }
            }
            result += currentNumber;
        }


        return result;
    }

}
