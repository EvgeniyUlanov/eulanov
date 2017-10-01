package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * class SimpleArrayList.
 * @param <E> - type of elements.
 */
public class SimpleArrayList<E> implements Iterable<E> {

    /** array to keep values.*/
    private Object[] data;
    /** size of values.*/
    private int size;

    /**
     * default constructor.
     */
    public SimpleArrayList() {
        this(10);
    }

    /**
     * constructor with size.
     * @param size - size.
     */
    public SimpleArrayList(int size) {
        this.data = new Object[size];
    }

    /**
     * metod add.
     * @param value - value.
     */
    public void add(E value) {
        if (size >= data.length) {
            increaseSize();
        }
        data[size++] = value;
    }

    /**
     * metod get.
     * @param index - index.
     * @return value.
     */
    public E get(int index) {
        return (E) data[index];
    }

    /**
     * iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int position;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                return (E) data[position++];
            }
        };
    }

    /**
     * metod increase data lenght.
     */
    private void increaseSize() {
        data = Arrays.copyOf(data, size * 3 / 2);
    }
}
