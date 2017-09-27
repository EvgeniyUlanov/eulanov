package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class ArrayIterator.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayIterator implements Iterator<Integer> {
    /** array values to keep incoming value.*/
    private ArrayList<Integer> values = new ArrayList<>();
    /** index of current element.*/
    private int index = 0;

    /**
     * constructor.
     * @param values - incoming value.
     */
    public ArrayIterator(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                this.values.add(values[i][j]);
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
     * @return
     */
    @Override
    public Integer next() {
        return values.get(index++);
    }
}
