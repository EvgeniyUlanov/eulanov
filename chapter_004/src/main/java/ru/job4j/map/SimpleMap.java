package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class SimpleMap.
 * @param <K> - key.
 * @param <V> - value.
 */
public class SimpleMap<K, V> implements Iterable<V> {
    /** data storage.*/
    private Object[] data;

    /**
     * default constructor.
     */
    public SimpleMap() {
        this(17);
    }

    /**
     * constructor with size.
     * @param size - size.
     */
    public SimpleMap(int size) {
        this.data = new Object[size];
    }

    /**
     * method insert.
     * @param key - key value.
     * @param value - value.
     * @return boolean.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int index = getIndex(key);
        if (data[index] == null) {
            data[index] = value;
            result = true;
        }
        return result;
    }

    /**
     * method get.
     * @param key - key value.
     * @return value.
     */
    public V get(K key) {
        int index = getIndex(key);
        if (data[index] == null) {
            throw new NoSuchElementException();
        }
        return (V) data[index];
    }

    /**
     * method delete.
     * @param key - key value.
     * @return boolean.
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (data[index] != null) {
            data[index] = null;
            result = true;
        }
        return result;
    }

    /**
     * method getIndex.
     * @param key - key value.
     * @return index in data.
     */
    private int getIndex(K key) {
        int index;
        if (key == null) {
            index = 0;
        } else {
            index = Math.abs(key.hashCode() % data.length);
        }
        return index;
    }

    /**
     * method iterator.
     * @return iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int index;
            private V value;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (; index < data.length; index++) {
                    if (data[index] != null) {
                        value = (V) data[index];
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                return value;
            }
        };
    }
}
