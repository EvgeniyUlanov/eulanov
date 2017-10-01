package ru.job4j.generic;

import java.util.Iterator;

/**
 * class SimpleArray.
 * @param <E> - type of elements to keep.
 */
public class SimpleArray<E> implements Iterable<E> {

    /** data storage.*/
    private Object[] data;
    /** current index.*/
    private int index;

    /**
     * default constructor.
     */
    public SimpleArray() {
        this(10);
    }

    /**
     * constructor.
     * @param size - size of array.
     */
    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    /**
     * metod add.
     * @param value - value to add.
     */
    public void add(E value) {
        this.data[index++] = value;
    }

    /**
     * metod get.
     * @param position - position.
     * @return value E.
     * @throws WrongPositionException - exception.
     */
    @SuppressWarnings("unchecked")
    public E get(int position) throws WrongPositionException {
        checkRightPosition(position);
        return (E) this.data[position];
    }

    /**
     * metod update.
     * @param position - position to update.
     * @param value - new value.
     * @throws WrongPositionException - exception.
     */
    public void update(int position, E value) throws WrongPositionException {
        checkRightPosition(position);
        this.data[position] = value;
    }

    /**
     * metod delete.
     * @param position - position.
     * @throws WrongPositionException - exception.
     */
    public void delete(int position) throws WrongPositionException {
        checkRightPosition(position);
        for (int i = position; i < this.data.length; i++) {
            if (i != this.data.length - 1) {
                this.data[i] = this.data[i + 1];
            } else {
                this.data[i] = null;
            }
        }
        this.index--;
    }

    /**
     * metod check position.
     * @param position - position.
     * @throws WrongPositionException - exception.
     */
    private void checkRightPosition(int position) throws WrongPositionException {
        if (position > index || position < 0) {
            throw new WrongPositionException("position is wrong");
        }
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
                return count < index;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) data[count++];
            }
        };
    }

    /**
     * metod size.
     * @return size.
     */
    public int size() {
        return index;
    }
}
