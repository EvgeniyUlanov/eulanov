package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class prime numbers iterator.
 */
public class PrimeNumbersIterator implements Iterator {
    /** values.*/
    private ArrayList<Integer> values = new ArrayList<>();
    /** index.*/
    private int index = 0;

    /**
     * constructor.
     * @param values - incoming array.
     */
    public PrimeNumbersIterator(int[] values) {
        for (Integer value : values) {
            if (checkPrimeNumber(value)) {
                this.values.add(value);
            }
        }
    }

    /**
     * metod has next.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return index < values.size();
    }

    /**
     * metod next.
     * @return Integer.
     */
    @Override
    public Integer next() {
        if (index >= values.size()) {
            return null;
        }
        return values.get(index++);
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
