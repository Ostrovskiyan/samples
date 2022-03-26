package com.aostrovskyi.samples.tasks.codewars;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).
 *
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 *
 * Courtesy of projecteuler.net (Problem 1)
 */
public class Solution {

    public int solution(int number) {
        int sum = 0;
        if (number < 4) {
            return sum;
        }

        int threeCounter = 0;
        int fiveCounter = 0;
        while (threeCounter < number || fiveCounter < number) {
            if (threeCounter < fiveCounter) {
                threeCounter += 3;
                if (threeCounter != fiveCounter && threeCounter < number) {
                    sum += threeCounter;
                }
            } else {
                fiveCounter += 5;
                if (threeCounter != fiveCounter && fiveCounter < number) {
                    sum += fiveCounter;
                }
            }
        }
        return sum;
    }
}