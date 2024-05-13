package org.game.components;

import java.util.Random;

public class Dice {
    private final int startOfDice;
    private final int endOfDice;

    public Dice(int startOfDice,int endOfDice) {
        this.startOfDice = startOfDice;
        this.endOfDice = endOfDice;
    }

    public int rollTheDice() {
        Random random = new Random();
        return random.nextInt(endOfDice - startOfDice + 1) + startOfDice;
    }
}
