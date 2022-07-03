package com.aostrovskyi.samples.tasks.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
 * <p>
 * The keypad has the following layout:
 * <p>
 * ┌───┬───┬───┐
 * │ 1 │ 2 │ 3 │
 * ├───┼───┼───┤
 * │ 4 │ 5 │ 6 │
 * ├───┼───┼───┤
 * │ 7 │ 8 │ 9 │
 * └───┼───┼───┘
 * │ 0 │
 * └───┘
 * He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
 * <p>
 * He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
 * <p>
 * * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
 * <p>
 * Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list in Java/Kotlin and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.
 * <p>
 * Detective, we are counting on you!
 */
public class ObservedPin {

    private static final Map<Character, List<Character>> POSSIBLE_ADJUSTED_DIGITS = new HashMap<>() {
        {
            put('1', List.of('1', '2', '4'));
            put('2', List.of('2', '1', '5', '3'));
            put('3', List.of('3', '2', '6'));
            put('4', List.of('4', '1', '5', '7'));
            put('5', List.of('5', '2', '4', '6', '8'));
            put('6', List.of('6', '3', '5', '9'));
            put('7', List.of('7', '4', '8'));
            put('8', List.of('8', '5', '7', '9', '0'));
            put('9', List.of('9', '6', '8'));
            put('0', List.of('0', '8'));
        }
    };

    public static List<String> getPINs(String observed) {
        char[] observedDigits = observed.toCharArray();
        List<String> possiblePINs = new ArrayList<>();
        for (Character observedDigit : observedDigits) {
            final List<String> variants = new ArrayList<>();
            final List<Character> possibleDigits = POSSIBLE_ADJUSTED_DIGITS.get(observedDigit);

            for (Character possibleDigit : possibleDigits) {
                if (possiblePINs.isEmpty()) {
                    variants.add(possibleDigit.toString());
                } else {
                    for (String variant : possiblePINs) {
                        variants.add(variant + possibleDigit.toString());
                    }
                }
            }
            possiblePINs = variants;
        }

        return possiblePINs;
    }

}
