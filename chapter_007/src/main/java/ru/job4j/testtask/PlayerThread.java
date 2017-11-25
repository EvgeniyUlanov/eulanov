package ru.job4j.testtask;

import java.util.Random;

/**
 * class PlayerThread.
 */
public class PlayerThread extends CharacterThread {

    PlayerThread(Character player) {
        super(player);
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        Character player = getCharacter();
        Random rn = new Random();
        player.blockPos();
        while (!getStop() && !Thread.currentThread().isInterrupted()) {
            try {
                int newX;
                int newY;
                int upStraight = rn.nextInt(2);
                int forwardBack = rn.nextInt(2);
                if (upStraight == 1) {
                    newY = player.getPosY();
                    if (forwardBack == 1) {
                        newX = player.getPosX() + 1;
                    } else {
                        newX = player.getPosX() - 1;
                    }
                } else {
                    newX = player.getPosX();
                    if (forwardBack == 1) {
                        newY = player.getPosY() + 1;
                    } else {
                        newY = player.getPosY() - 1;
                    }
                }
                player.move(newX, newY);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.format("%s is stop.\n", Thread.currentThread().getName());
                setStop();
            }
        }
    }
}