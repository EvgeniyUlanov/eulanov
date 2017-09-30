package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class ArrayIterator.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator implements Iterator<Integer> {
    /** values.*/
    private final int[] values;
    /** index.*/
    private int index;

    /**
     * constructor.
     * @param incoming - incoming array.
     */
    public EvenIterator(final int[] incoming) {
        this.values = incoming;
    }

    /**
     * metod hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * metod next.
     * @return value
     */
    @Override
    public Integer next() {
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                index = i + 1;
                return values[i];
            }
        }
        return null;
    }
}
