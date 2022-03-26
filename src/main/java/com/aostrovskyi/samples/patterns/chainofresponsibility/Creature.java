package com.aostrovskyi.samples.patterns.chainofresponsibility;

abstract class Creature {
    public abstract int getAttack();

    public abstract int getDefense();

    public Buff getBuff() {
        return new Buff(this) {
            @Override
            public void apply(Query query) {
                // do nothing
            }
        };
    }
}
