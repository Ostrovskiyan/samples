package com.aostrovskyi.samples.patterns.chainofresponsibility;

public abstract class Buff {

    private Creature creature;

    public Buff(Creature creature) {
        this.creature = creature;
    }

    public abstract void apply(Query query);

    public boolean isAppliable(Query query) {
        return creature != query.getCreature();
    }

}
