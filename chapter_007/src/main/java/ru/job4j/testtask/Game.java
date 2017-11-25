package ru.job4j.testtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class Game.
 */
public class Game {
    /** board.*/
    private final ReentrantLock[][] board;
    /** mask of field - 0 empty cell, 1 - wall, 2 - player, 3 - enemy.*/
    private final static int[][] MASK = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 2, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 3, 0, 1},
            {1, 0, 3, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    /**
     * constructor.
     */
    public Game() {
        board = new ReentrantLock[MASK.length][MASK[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
                if (MASK[i][j] == 1) {
                    board[i][j].lock();
                }
            }
        }
    }

    /**
     * method start.
     * @throws InterruptedException - InterruptedException.
     */
    public void start() throws InterruptedException {
        Thread player = null;
        List<Thread> enemies = new ArrayList<>();
        for (int i = 0; i < MASK.length; i++) {
            for (int j = 0; j < MASK[i].length; j++) {
                if (MASK[i][j] == 2) {
                    player = new Thread(new PlayerThread(new Character(board, j, i)));
                    player.setName("Player");
                }
                if (MASK[i][j] == 3) {
                    Thread enemy = new Thread(new EnemyThread(new Character(board, j, i)));
                    enemy.setName("Enemy" + i);
                    enemies.add(enemy);
                }
            }
        }
        if (player != null) {
            player.start();
        }
        for (Thread thread : enemies) {
            thread.start();
        }
    }
}