package com.aostrovskyi.samples.patterns.builder;

public class TestMain {

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }

}
