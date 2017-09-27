package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class ArrayIterator.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class EvenIterator implements Iterator<Integer> {
    /** values.*/
    private final ArrayList<Integer> values = new ArrayList<>();
    /** index.*/
    private int index = 0;

    /**
     * constructor.
     * @param incoming - incoming array.
     */
    public EvenIterator(final int[] incoming) {
        for (int value : incoming) {
            if (value % 2 == 0) {
                values.add(value);
            }
        }
    }

    /**
     * metod hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return index < values.size();
    }

    /**
     * metod next.
     * @return value
     */
    @Override
    public Integer next() {
        return values.get(index++);
    }
}
