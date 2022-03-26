package com.aostrovskyi.samples.patterns.factory;

import java.util.concurrent.atomic.AtomicInteger;

public class PersonFactory {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public Person createPerson(String name) {
        return new Person(counter.getAndIncrement(), name);
    }
}
