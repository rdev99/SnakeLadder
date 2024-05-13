package org.game.components;

import org.game.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadderGame {

    private final Board board;
    private final Dice dice;
    private final List<Player> players;


    public SnakeLadderGame(int numberOfDice) {
        board = new Board();
        dice = new Dice(numberOfDice, numberOfDice * 6);
        players = new ArrayList<>();
    }

    public void initGame() {
        System.out.println("Lets start the game, paste the input");
        Scanner sc = new Scanner(System.in);
        int noOfSnakes = sc.nextInt();
        for (int i = 0; i < noOfSnakes; i++) {
            int head = sc.nextInt(), tail = sc.nextInt();
            board.setSnake(head, tail);
        }
        int noOfLadders = sc.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            int head = sc.nextInt(), tail = sc.nextInt();
            board.setLadder(head, tail);
        }
        int noOfPlayers = sc.nextInt();
        for(int i=0;i<noOfPlayers;i++) {
            players.add(new Player(sc.next()));
        }
    }

    public void startGame() {
        int currentPlayer = 0;
        while(true) {
            currentPlayer++;
            if(currentPlayer==players.size()) {
                currentPlayer=0;
            }
            int diceNumber = dice.rollTheDice();
            Player player = players.get(currentPlayer);
            int newPosition = player.getPosition()+diceNumber;
            System.out.println("Player "+player.getName()+" got "+diceNumber+" on the dice");
            System.out.println("Player "+player.getName()+" new position will be "+newPosition);
            if(newPosition>100) {
                System.out.println("Uh oh, Dice value goes out of board so returning to old position of "+player.getPosition());
                continue;
            }
            if(newPosition == 100) {
                player.setPosition(newPosition);
                player.setIsPlayerWon(true);
                System.out.println("Oh Yeah,"+player.getName()+" won the Game!!!!!!!!!!!!");
                break;
            }
            boolean isLadder = board.isLadder(newPosition);
            boolean isSnake = board.isSnake(newPosition);
            while(isLadder || isSnake) {
                if(isLadder) {
                    newPosition = board.getLadder(newPosition);
                    System.out.println("Got the ladder, final position is "+newPosition);

                }
                if(isSnake) {
                    newPosition = board.getSnake(newPosition);
                    System.out.println("Uh oh, Got the Snake, final position is "+newPosition);
                }

                isLadder = board.isLadder(newPosition);
                isSnake = board.isSnake(newPosition);
            }
            player.setPosition(newPosition);
        }
    }

}
