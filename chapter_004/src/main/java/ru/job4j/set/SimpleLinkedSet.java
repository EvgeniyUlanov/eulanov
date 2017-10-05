package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;

/**
 * class SimpleLinkedSet.
 * @param <E> - type.
 */
public class SimpleLinkedSet<E> implements Iterable<E> {

    /** data storage.*/
    private SimpleLinkedList<E> data = new SimpleLinkedList<>();

    /**
     * metod add.
     * @param value - value.
     */
    public void add(E value) {
        if (!hasElement(value)) {
            data.add(value);
        }
    }

    /**
     * metod check that this value exist in array.
     * @param value - value.
     * @return boolean.
     */
    private boolean hasElement(E value) {
        boolean result = false;
        for (E val : data) {
            if (val.equals(value)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * method iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
