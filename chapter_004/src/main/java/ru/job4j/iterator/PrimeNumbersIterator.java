package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class prime numbers iterator.
 */
public class PrimeNumbersIterator implements Iterator {
    /** values.*/
    private final int[] values;
    /** index.*/
    private int index = 0;

    /**
     * constructor.
     * @param values - incoming array.
     */
    public PrimeNumbersIterator(final int[] values) {
        this.values = values;
    }

    /**
     * method has next.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        boolean bool = false;
        for (int i = index; i < values.length; i++) {
            if (checkPrimeNumber(values[i])) {
                bool = true;
                index = i;
                break;
            }
        }
        return bool;
    }

    /**
     * method next.
     * @return Integer.
     */
    @Override
    public Integer next() {
        int result;
        if (hasNext()) {
            result = values[index];
            index++;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * method checks Prime number.
     * @param i - number.
     * @return bool.
     */
    private boolean checkPrimeNumber(int i) {
        boolean result = true;
        for (long j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                result = false;
                break;
            }
        }
        if (i == 1 || i == 0) {
            result = false;
        }
        return result;
    }
}
