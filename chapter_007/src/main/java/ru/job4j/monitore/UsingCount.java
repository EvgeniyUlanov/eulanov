package ru.job4j.monitore;

import net.jcip.annotations.ThreadSafe;

/**
 * class UsingCount.
 */
public class UsingCount {

    public static void main(String[] args) throws InterruptedException {
        UsingCount using = new UsingCount();
        Count count = new Count();
        for (int i = 0; i < 200; i++) {
            CountThread thread = new CountThread(count);
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(count.getCount());
    }
}

class CountThread extends Thread {

    private Count count;

    CountThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count.increment();
        }
    }
}
