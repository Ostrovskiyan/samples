package com.aostrovskyi.samples.patterns.factory;

public class TestMain {

    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();
        System.out.println(factory.createPerson("Alik"));
        System.out.println(factory.createPerson("Max"));
        System.out.println(factory.createPerson("Kos"));
        System.out.println(factory.createPerson("Vlad"));
    }

}
