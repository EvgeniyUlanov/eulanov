package ru.job4j.testtask;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class Game.
 */
public class Game {
    /** board.*/
    private final ReentrantLock[][] board;

    /**
     * default constructor.
     */
    public Game() {
        this(10, 10);
    }

    /**
     * constructor with rows and columns.
     * @param x - x rows.
     * @param y - y columns.
     */
    public Game(int x, int y) {
        board = new ReentrantLock[y][x];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * method start.
     * @throws InterruptedException - InterruptedException.
     */
    public void start() throws InterruptedException {
        Thread thread = new Thread(new PlayerThread(board));
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}

/**
 * class PlayerThread.
 */
class PlayerThread implements Runnable {
    /** random.*/
    private Random rn = new Random();
    /** boolean isStop.*/
    private boolean isStop;
    /** board.*/
    private ReentrantLock[][] board;

    /**
     * constructor.
     * @param board - board.
     */
    public PlayerThread(ReentrantLock[][] board) {
        this.board = board;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        Player player = new Player(board);
        while (!isStop && !Thread.currentThread().isInterrupted()) {
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
                System.out.println("Is stop.");
                isStop = true;
            }
        }
    }
}