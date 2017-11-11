package ru.job4j.jmm;

/**
 * class ProblemsWithMultiThreading.
 */
public class ProblemsWithMultiThreading {

    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        for (int i = 0; i < 200; i++) {
            new Thread(count).start();
        }
        Thread.sleep(2000);
        System.out.println(count.getCount());
    }
}

/**
 * class Counter.
 */
class Counter implements Runnable {
    /** count.*/
    private int count = 0;
    /** method increment.*/
    private void increment() {
        count++;
    }
    /** method getCount.*/
    int getCount() {
        return count;
    }
    /** method run.*/
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }
}
