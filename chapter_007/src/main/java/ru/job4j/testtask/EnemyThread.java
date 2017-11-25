package ru.job4j.testtask;

import java.util.Random;

public class EnemyThread extends CharacterThread {

    EnemyThread(Character enemy) {
        super(enemy);
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        Character enemy = getCharacter();
        Random rn = new Random();
        enemy.blockPos();
        while (!getStop() && !Thread.currentThread().isInterrupted()) {
            try {
                int newX;
                int newY;
                int upDown = rn.nextInt(2);
                int forwardBack = rn.nextInt(2);
                boolean canMove = true;
                while (canMove) {
                    if (upDown == 1) {
                        newY = enemy.getPosY();
                        if (forwardBack == 1) {
                            newX = enemy.getPosX() + 1;
                        } else {
                            newX = enemy.getPosX() - 1;
                        }
                    } else {
                        newX = enemy.getPosX();
                        if (forwardBack == 1) {
                            newY = enemy.getPosY() + 1;
                        } else {
                            newY = enemy.getPosY() - 1;
                        }
                    }
                    canMove = enemy.move(newX, newY);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.format("%s is stop.\n", Thread.currentThread().getName());
                setStop();
            }
        }
    }
}
