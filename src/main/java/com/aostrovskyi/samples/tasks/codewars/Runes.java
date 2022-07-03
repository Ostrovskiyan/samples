package com.aostrovskyi.samples.tasks.codewars;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * To give credit where credit is due: This problem was taken from the ACMICPC-Northwest Regional Programming Contest. Thank you problem writers.
 *
 * You are helping an archaeologist decipher some runes. He knows that this ancient society used a Base 10 system, and that they never start a number with a leading zero. He's figured out most of the digits as well as a few operators, but he needs your help to figure out the rest.
 *
 * The professor will give you a simple math expression, of the form
 *
 * [number][op][number]=[number]
 * He has converted all of the runes he knows into digits. The only operators he knows are addition (+),subtraction(-), and multiplication (*), so those are the only ones that will appear. Each number will be in the range from -1000000 to 1000000, and will consist of only the digits 0-9, possibly a leading -, and maybe a few ?s. If there are ?s in an expression, they represent a digit rune that the professor doesn't know (never an operator, and never a leading -). All of the ?s in an expression will represent the same digit (0-9), and it won't be one of the other given digits in the expression. No number will begin with a 0 unless the number itself is 0, therefore 00 would not be a valid number.
 *
 * Given an expression, figure out the value of the rune represented by the question mark. If more than one digit works, give the lowest one. If no digit works, well, that's bad news for the professor - it means that he's got some of his runes wrong. output -1 in that case.
 *
 * Complete the method to solve the expression to find the value of the unknown rune. The method takes a string as a paramater repressenting the expression and will return an int value representing the unknown rune or -1 if no such rune exists.
 */
public class Runes {

    public static int solveExpression( final String expression ) {
        String[] equalityExpressions = expression.split("=");
        String computingExpression = equalityExpressions[0];
        String resultTemplate = equalityExpressions[1];
        Computing computing = Computing.create(computingExpression);

        for (int i = 0; i < 10; i++) {
            if (i == 0 && expression.contains("??")
                || expression.contains(String.valueOf(i))) {
                continue;
            }
            int resultValue = eval(resultTemplate, i);
            int leftValue = eval(computing.getLeft(), i);
            int rightValue = eval(computing.getRight(), i);
            if (resultValue == computing.getOperator().compute(leftValue, rightValue)) {
                return i;
            }
        }

        return -1;
    }

    private static int eval(String template, int i) {
        String replaced = template.replaceAll("\\?", String.valueOf(i));
        return Integer.parseInt(replaced);
    }

}

class Computing {
    private final String left;
    private final Operator operator;
    private final String right;

    private Computing(String left, Operator operator, String right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public static Computing create(String expression) {
        return Arrays.stream(Operator.values())
            .flatMap(operation -> {
                String regex = "^.*(\\d|\\?)%s(\\d|-|\\?).*$".formatted("\\" + operation.getOperator());
                if (expression.matches(regex)) {
                    int index = expression.indexOf(operation.getOperator(), 1);
                    String left = expression.substring(0, index);
                    String right = expression.substring(index + 1);
                    return Stream.of(new Computing(left, operation, right));
                }
                return Stream.empty();
            })
            .findFirst()
            .orElseThrow();

    }

    public String getLeft() {
        return left;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getRight() {
        return right;
    }
}

enum Operator {
    PLUS('+', Integer::sum),
    MINUS('-', (n1, n2) -> n1 - n2),
    MULTIPLY('*', (n1, n2) -> n1 * n2);

    private final char operator;
    private final BinaryOperator<Integer> binaryOperator;

    Operator(char operator, BinaryOperator<Integer> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public char getOperator() {
        return operator;
    }

    public int compute(int n1, int n2) {
        return binaryOperator.apply(n1, n2);
    }

}