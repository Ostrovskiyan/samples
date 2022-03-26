package com.aostrovskyi.samples.patterns.flyweight;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {
    private final List<WordToken> tokens;

    public Sentence(String plainText) {
        this.tokens = Stream.of(plainText.split(" "))
                .map(WordToken::new)
                .collect(Collectors.toList());
    }

    public WordToken getWord(int index) {
        return tokens.get(index);
    }

    @Override
    public String toString() {
        return tokens.stream()
                .map(WordToken::toString)
                .collect(Collectors.joining(" "));
    }

    class WordToken {
        public boolean capitalize;
        private String word;

        public WordToken(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return capitalize ? word.toUpperCase() : word;
        }
    }
}
