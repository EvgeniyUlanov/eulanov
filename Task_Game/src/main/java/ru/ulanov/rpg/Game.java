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
        int count = 1;
        do {
            System.out.println(String.format("Turn - %s", count));
            field.nextTurn();
            System.out.println("End of turn");
            count++;
            System.out.println("");
        } while (leftPlayer.getHand().size() > 0 && rightPlayer.getHand().size() > 0);
        System.out.println(String.format("The game ended on %s turn", count));
        if (rightPlayer.getHand().size() == 0) {
            System.out.println(String.format("%s win, remained %s units", leftPlayer.getRaceName(),
                    leftPlayer.getHand().size()));
        } else {
            System.out.println(String.format("%s win, remained %s units", rightPlayer.getRaceName(),
                    rightPlayer.getHand().size()));
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