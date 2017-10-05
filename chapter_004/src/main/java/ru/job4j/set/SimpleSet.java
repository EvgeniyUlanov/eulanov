package ru.job4j.set;

import java.util.Iterator;

/**
 * class SimpleSet.
 * @param <E> - type.
 */
public class SimpleSet<E> implements Iterable<E> {

    /** array to keep value.*/
    private Object[] data;
    /** size.*/
    private int size;

    /**
     * default constructor.
     */
    public SimpleSet() {
        this(10);
    }

    /**
     * constructor.
     * @param size - size.
     */
    public SimpleSet(int size) {
        this.data = new Object[size];
    }

    /**
     * method add.
     * @param value - incoming value.
     */
    public void add(E value) {
        if (size < data.length && !hasElement(value)) {
            data[size++] = value;
        }
    }

    /**
     * metod check that this value exist in array.
     * @param value - value.
     * @return boolean.
     */
    private boolean hasElement(E value) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].equals(value)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * metod iterator.
     * @return iterator.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int count;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                return (E) data[count++];
            }
        };
    }
}
