package com.aostrovskyi.samples.patterns.state;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationLock {
    private Set<String> finiteStatuses = new HashSet<>() {{
        add("OPEN");
        add("ERROR");
    }};

    private int[] combination;
    private String combinationString;
    public String status;

    public CombinationLock(int[] combination) {
        this.combination = combination;
        this.combinationString = IntStream.of(combination)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        this.status = "LOCKED";
    }

    public void enterDigit(int digit) {
        if (finiteStatuses.contains(status)) {
            return;
        }

        if (status.equals("LOCKED")) {
            status = Integer.toString(digit);
        } else {
            status += Integer.toString(digit);
        }

        if (status.length() == combinationString.length()) {
            if (status.equals(combinationString)) {
                status = "OPEN";
            } else {
                status = "ERROR";
            }
        }
    }
}
