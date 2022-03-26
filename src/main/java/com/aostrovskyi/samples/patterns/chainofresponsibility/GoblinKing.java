package com.aostrovskyi.samples.patterns.chainofresponsibility;

class GoblinKing extends Goblin {

    private int baseAttack;
    private int baseDefense;

    public GoblinKing(Game game) {
        super(game);
        this.baseAttack = 3;
        this.baseDefense = 3;
    }

    @Override
    public int getAttack() {
        Query query = new Query(this, Statistic.ATTACK, 3);
        game.applyBuffs(query);
        return query.getValue();
    }

    @Override
    public int getDefense() {
        Query query = new Query(this, Statistic.DEFENSE, 3);
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
                        && query.getCreature() instanceof Goblin;
            }
        };
    }
}
