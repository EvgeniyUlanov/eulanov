package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * method hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * method next.
     * @return value
     */
    @Override
    public Integer next() {
        Integer result;
        if (hasNext()) {
            result = values[index];
            index++;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
