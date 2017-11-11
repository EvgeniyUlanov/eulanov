package ru.job4j.jmm;

/**
 * class DeadLock.
 */
public class Deadlock {
    /**
     * main method.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        Thread someThread = new Thread(new SomeClass(thread));
        someThread.start();
        someThread.join();
    }

}

/**
 * class SomeClass.
 */
class SomeClass implements Runnable {
    /** link to main method.*/
    private Thread mainThread;

    /**
     * constructor.
     * @param mainThread - main thread.
     */
    SomeClass(Thread mainThread) {
        this.mainThread = mainThread;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
