package com.aostrovskyi.samples.patterns.proxy;

public class ResponsiblePerson extends Person {
    private Person person;

    public ResponsiblePerson(Person person) {
        super(person.getAge());
    }

    @Override
    public String drink() {
        if (getAge() < 18) {
            return super.drink();
        } else {
            return "too young";
        }
    }

    @Override
    public String drive() {
        if (getAge() < 16) {
            return super.drive();
        } else {
            return "too young";
        }
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }
}
