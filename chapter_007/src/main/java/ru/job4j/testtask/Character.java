package ru.job4j.testtask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class Player.
 */
public class Character {
    /** x position.*/
    private int posX;
    /** y position.*/
    private int posY;
    /** board.*/
    private ReentrantLock[][] board;

    /**
     * constructor.
     * @param board - board.
     */
    public Character(ReentrantLock[][] board, int x, int y) {
        this.board = board;
        posY = y;
        posX = x;
    }

    /**
     * metod getPosX.
     * @return posX.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * metod getPosY.
     * @return posY.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * method move.
     * @param x - new position x.
     * @param y - new position y.
     * @return boolean
     * @throws InterruptedException - InterruptedException.
     */
    public boolean move(int x, int y) throws InterruptedException {
        boolean result = false;
        if (x < board[posY].length && x >= 0 && y < board.length && y >= 0) {
            result = board[y][x].tryLock(500, TimeUnit.MILLISECONDS);
            if (result) {
                board[posY][posX].unlock();
                posX = x;
                posY = y;
                System.out.format("%s was moved to x - %s, y - %s\n", Thread.currentThread().getName(), posX, posY);
            }
        }
        return result;
    }

    public void blockPos() {
        this.board[posY][posX].lock();
    }
}