package com.aostrovskyi.samples.patterns.flyweight;

public class TestMain {
    public static void main(String[] args) {
        var sentence = new Sentence("Alik love marina and coding and programing and gaming");
        sentence.getWord(2).capitalize = true;
        sentence.getWord(4).capitalize = true;
        sentence.getWord(6).capitalize = true;
        sentence.getWord(0).capitalize = true;

        System.out.println(sentence.toString());
    }
}
