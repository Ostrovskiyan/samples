package com.aostrovskyi.samples.patterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

class Game {
    public List<Creature> creatures = new ArrayList<>();

    public void applyBuffs(Query query) {
        creatures.stream()
                .map(Creature::getBuff)
                .filter(buff -> buff.isAppliable(query))
                .forEach(buff -> buff.apply(query));
    }

}
