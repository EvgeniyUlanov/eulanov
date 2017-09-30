package ru.job4j.iterator;

import java.util.Iterator;

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
     * metod has next.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (checkPrimeNumber(values[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * metod next.
     * @return Integer.
     */
    @Override
    public Integer next() {
        for (int i = index; i < values.length; i++) {
            if (checkPrimeNumber(values[i])) {
                index = i + 1;
                return values[i];
            }
        }
        return null;
    }

    /**
     * metod checks Prime number.
     * @param i - number.
     * @return bool.
     */
    private boolean checkPrimeNumber(Integer i) {
        for (long j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
