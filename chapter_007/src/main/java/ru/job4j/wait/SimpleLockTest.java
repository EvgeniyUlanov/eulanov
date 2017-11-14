package ru.job4j.wait;

/**
 * class SimpleLock.
 */
public class SimpleLockTest {
    /** count.*/
    private int count;
    /** lock.*/
    private SimpleLock lock = new SimpleLock();

    /**
     * method start.
     * @throws InterruptedException - InterruptedException.
     */
    public static void start() throws InterruptedException {
        SimpleLockTest test = new SimpleLockTest();
        Thread thread1 = new SampleThread(test);
        Thread thread2 = new SampleThread(test);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("Starting interrupt.");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(100);
        System.out.println("Finish");
    }

    /**
     * method increment.
     * @throws InterruptedException - InterruptedException.
     */
    void increment() throws InterruptedException {
        lock.lock();
        try {
            count++;
            System.out.format("Count was increased to %s by %s\n", count, Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    /**
     * main method.
     * @param args - args.
     * @throws InterruptedException - InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        start();
    }
}

/**
 * class SampleTread.
 */
class SampleThread extends Thread {
    /** boolean isStoped.*/
    private boolean isStoped = false;
    /** test.*/
    private SimpleLockTest test;

    /**
     * constructor.
     * @param test - test.
     */
    SampleThread(SimpleLockTest test) {
        this.test = test;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        while (!isStoped) {
            try {
                test.increment();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.format("Thread %s was interrupted\n", Thread.currentThread().getName());
                isStoped = true;
            }
        }
    }
}
