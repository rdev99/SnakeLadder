package org.game.models;

public class Player {
    private final String name;
    private int position;
    private boolean isPlayerWon;

    public Player(String name) {
        this.name = name;
        position = 0;
        isPlayerWon = false;
    }

    public int getPosition() {
        return position;
    }

    public void setIsPlayerWon(boolean isPlayerWon) {
        this.isPlayerWon = isPlayerWon;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

}
