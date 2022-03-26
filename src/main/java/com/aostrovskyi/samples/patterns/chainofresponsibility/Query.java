package com.aostrovskyi.samples.patterns.chainofresponsibility;

public class Query {

    private Creature creature;
    private Statistic statistic;
    private int value;

    public Query(Creature creature, Statistic statistic, int value) {
        this.creature = creature;
        this.statistic = statistic;
        this.value = value;
    }

    public Creature getCreature() {
        return creature;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
