package ru.job4j.set;

import java.util.HashMap;
import java.util.Iterator;

/**
 * class SimpleSet.
 * @param <E> - type.
 */
public class SimpleHashSet<E> {

    /** array to keep value.*/
    private HashMap<Integer, E> data = new HashMap<>();
    /** size.*/
    private int size;

    /**
     * method add.
     * @param value - incoming value.
     */
    public void add(E value) {
        if (hasElement(value)) {
            data.put(value.hashCode(), value);
        }
        size++;
    }

    /**
     * metod check that this value exist in array.
     * @param value - value.
     * @return boolean.
     */
    private boolean hasElement(E value) {
        return data.containsValue(value);
    }
}
