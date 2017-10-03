package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class ArrayIterator.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayIterator implements Iterator<Integer> {
    /** incoming values.*/
    private final int[][] values;
    /** currentArray.*/
    private int[] currentArray;
    /** index of current element in currentArray.*/
    private int index;
    /** count of arrays.*/
    private int arrayCount;

    /**
     * constructor.
     * @param values - incoming value.
     */
    public ArrayIterator(final int[][] values) {
        this.values = values;
        currentArray = values[0];
        arrayCount = values.length - 1;
    }

    /**
     * metod hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return arrayCount > 0 || index < currentArray.length;
    }

    /**
     * metod next.
     * @return integer.
     */
    @Override
    public Integer next() {
        Integer result;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (index == currentArray.length) {
            currentArray = values[values.length - arrayCount];
            arrayCount--;
            index = 0;
        }
        result = currentArray[index];
        index++;
        return result;
    }
}
