package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * class Count.
 */
@ThreadSafe
public class Count {

    @GuardedBy("this") private long count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized long getCount() {
        return count;
    }
}
