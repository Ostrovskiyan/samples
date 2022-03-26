package com.aostrovskyi.samples.patterns.interpreter;

import com.aostrovskyi.samples.patterns.proxy.Person;

import java.util.HashMap;
import java.util.Map;

public class ExpressionProcessor {
    public Map<Character, Integer> variables = new HashMap<>();

    enum Operation {
        PLUS, MINUS
    }

    public int calculate(String expression) {
        char[] chars = expression.toCharArray();
        Integer left = null;
        Operation operation = null;

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            if (isVariable(current)) {
                if (i + 1 < chars.length && isVariable(chars[i + 1])
                        || !variables.containsKey(current)
                ) {
                    return 0;
                }

                Integer variableValue = variables.get(current);
                if (left == null) {
                    left = variableValue;
                } else {
                    left = calculate(left, operation, variableValue);
                }
            } else if (Character.isDigit(current)) {
                StringBuilder sb = new StringBuilder();
                sb.append(current);
                for (int j = i + 1; j < expression.length(); j++) {
                    if (Character.isDigit(chars[j])) {
                        sb.append(chars[j]);
                        i++;
                    } else {
                        break;
                    }
                }

                int value = Integer.parseInt(sb.toString());
                if (left == null) {
                    left = value;
                } else {
                    left = calculate(left, operation, value);
                }
            } else if (current == '+') {
                operation = Operation.PLUS;
            } else if (current == '-') {
                operation = Operation.MINUS;
            }
        }

        return left == null ? 0 : left;
    }

    private Integer calculate(Integer left, Operation operation, Integer variableValue) {
        switch (operation) {
            case PLUS:
                left += variableValue;
                break;
            case MINUS:
                left -= variableValue;
                break;
        }
        return left;
    }

    private boolean isVariable(char current) {
        return Character.isAlphabetic(current);
    }
}
