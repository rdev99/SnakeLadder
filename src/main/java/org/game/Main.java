package org.game;

import org.game.components.SnakeLadderGame;

public class Main {
    public static void main(String[] args) {
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame(1);
        snakeLadderGame.initGame();
        snakeLadderGame.startGame();
    }
}
