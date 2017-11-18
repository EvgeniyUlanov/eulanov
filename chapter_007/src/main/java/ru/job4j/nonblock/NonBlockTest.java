package ru.job4j.nonblock;

public class NonBlockTest {
    /**
     * method start.
     * @throws InterruptedException - InterruptedException
     */
    public static void start() throws InterruptedException {
        NonBlockCash cash = new NonBlockCash();
        for (int i = 0; i < 5; i++) {
            cash.add(new Model("name" + i, i));
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Rename(cash));
            thread.setName("Thread " + i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(cash);
    }

    /**
     * method main.
     * @param args - args.
     * @throws InterruptedException - InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        start();
    }
}