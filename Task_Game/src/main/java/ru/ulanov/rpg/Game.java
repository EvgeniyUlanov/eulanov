package ru.ulanov.rpg;

import java.util.Random;

/**
 * class Game - main class.
 */

public class Game {
    /**
     * main metod.
     * @param args - args.
     */
    public static void main(String[] args) {
        Player leftPlayer = choosePlayerLeft();
        System.out.printf("First player race - %s", leftPlayer.getRaceName());
        System.out.println("");
        Player rightPlayer = choosePlayerRight();
        System.out.println(String.format("Second player race - %s", rightPlayer.getRaceName()));
        Field field = new Field(leftPlayer, rightPlayer);
        do {
            field.nextTurn();
            System.out.println("End of turn");
        } while (leftPlayer.getHand().size() > 0 && rightPlayer.getHand().size() > 0);
        if (rightPlayer.getHand().size() == 0) {
            System.out.println("Player left win.");
            System.out.println(leftPlayer.getHand());
            System.out.println(rightPlayer.getHand());
        } else {
            System.out.println("Player right win");
            System.out.println(leftPlayer.getHand());
            System.out.println(rightPlayer.getHand());
        }
    }

    /**
     * metod choose leftplayer squad.
     * @return player.
     */
    private static Player choosePlayerLeft() {
        Random rn = new Random();
        if (rn.nextInt(2) == 0) {
            return new PlayerElf("left");
        }
        return new PlayerHuman("left");
    }

    /**
     * metod choose right player.
     * @return player.
     */
    private static Player choosePlayerRight() {
        Random rn = new Random();
        if (rn.nextInt(2) == 0) {
            return new PlayerOrc("right");
        }
        return new PlayerUndead("right");
    }
}