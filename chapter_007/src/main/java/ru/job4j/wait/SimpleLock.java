package ru.job4j.wait;

/**
 * class SimpleLock.
 */
public class SimpleLock {

    /** boolean isLocked*/
    private boolean isLocked;

    /**
     * method lock.
     * @throws InterruptedException - InterruptedException.
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            this.wait();
        }
        isLocked = true;
    }

    /**
     * method unlock.
     */
    public synchronized void unlock() {
        isLocked = false;
        this.notifyAll();
    }
}
