package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class ArrayIterator.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayIterator implements Iterator<Integer> {
    /** incoming values.*/
    private final int[][] values;
    /** index of current element.*/
    private int index = 0;

    /**
     * constructor.
     * @param values - incoming value.
     */
    public ArrayIterator(final int[][] values) {
        this.values = values;
    }

    /**
     * metod hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        int sumIndex = 0;
        for (int i = 0; i < values.length; i++) {
            sumIndex += values[i].length;
        }
        return index < sumIndex;
    }

    /**
     * metod next.
     * @return integer.
     */
    @Override
    public Integer next() {
        int sumInd = 0;
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            sumInd += values[i].length;
            if (index < sumInd) {
                result = values[i][values.length - (sumInd - index)];
                break;
            }
        }
        index++;
        return result;
    }
}
