package com.aostrovskyi.samples.tasks.codewars;

import java.util.stream.Stream;

/**
 * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
 *
 * Examples
 * highAndLow("1 2 3 4 5")  // return "5 1"
 * highAndLow("1 2 -3 4 5") // return "5 -3"
 * highAndLow("1 9 3 4 -5") // return "9 -5"
 * Notes
 * All numbers are valid Int32, no need to validate them.
 * There will always be at least one number in the input string.
 * Output string must be two numbers separated by a single space, and highest number is first.
 */
public class HighAndLow {

    public static String highAndLow(String numbers) {
        return Stream.of(numbers.split(" "))
                .map(Integer::parseInt)
                .reduce(
                    new Result(),
                    Result::processNewValue,
                    Result::mergeResults
                )
                .toString();
    }

    static class Result {
        private Integer highest;
        private Integer lowest;

        public Result() {
            this.highest = Integer.MIN_VALUE;
            this.lowest = Integer.MAX_VALUE;
        }

        private Result processNewValue(Integer value) {
            if (highest < value) {
                highest = value;
            }
            if (lowest > value) {
                lowest = value;
            }
            return this;
        }

        private Result mergeResults(Result result) {
            if (highest < result.highest) {
                highest = result.highest;
            }
            if (lowest > result.lowest) {
                lowest = result.lowest;
            }
            return this;
        }

        @Override
        public String toString() {
            return String.format("%d %d", highest, lowest);
        }
    }
}
