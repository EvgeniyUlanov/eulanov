package ru.job4j.wait;

/**
 * class ThreadPool.
 */
public class ThreadPoolTest {
    /**
     * method start.
     * @throws InterruptedException - InterruptedException.
     */
    public static void start() throws InterruptedException {
        System.out.println("Start.");
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 20; i++) {
            Work work = new Work("work" + i);
            threadPool.add(work);
            System.out.println(String.format("Work %s added", work.getName()));
        }
        Thread.sleep(1000);
        threadPool.stopThreadPool();
        Thread.sleep(500);
        System.out.println("Finish.");
    }

    /**
     * method main.
     * @param args - args.
     * @throws InterruptedException - InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTest.start();
    }
}

