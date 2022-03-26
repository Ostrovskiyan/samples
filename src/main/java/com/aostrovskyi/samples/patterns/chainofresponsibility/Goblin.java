package com.aostrovskyi.samples.patterns.chainofresponsibility;

class Goblin extends Creature {

    protected Game game;

    public Goblin(Game game) {
        this.game = game;
    }

    @Override
    public int getAttack() {
        Query query = new Query(this, Statistic.ATTACK, 1);
        game.applyBuffs(query);
        return query.getValue();
    }

    @Override
    public int getDefense() {
        Query query = new Query(this, Statistic.DEFENSE, 1);
        game.applyBuffs(query);
        return query.getValue();
    }

    @Override
    public Buff getBuff() {
        return new Buff(this) {
            @Override
            public void apply(Query query) {
                query.setValue(query.getValue() + 1);
            }

            @Override
            public boolean isAppliable(Query query) {
                return super.isAppliable(query)
                        && query.getCreature() instanceof Goblin
                        && query.getStatistic() == Statistic.DEFENSE;
            }
        };
    }
}
