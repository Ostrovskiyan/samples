package com.aostrovskyi.samples.patterns.chainofresponsibility;

public class TestMain {

    public static void main(String[] args) {
        Game game = new Game();
        game.creatures.add(new Goblin(game));
        game.creatures.add(new Goblin(game));
        game.creatures.add(new Goblin(game));
        game.creatures.add(new GoblinKing(game));

        System.out.println(game.creatures.get(0).getAttack());
        System.out.println(game.creatures.get(0).getDefense());
        System.out.println(game.creatures.get(3).getAttack());
        System.out.println(game.creatures.get(3).getDefense());
    }

}
