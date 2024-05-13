package org.game.components;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final int BOARD_SIZE = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public int getSnake(int head) {
        return snakes.get(head);
    }

    public int getLadder(int head) {
        return ladders.get(head);
    }

    public void setSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void setLadder(int head, int tail) {
        ladders.put(head, tail);
    }

    public boolean isLadder(int head) {
        return ladders.containsKey(head);
    }

    public boolean isSnake(int head) {
        return snakes.containsKey(head);
    }


}
