package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class converter.
 */

public class Converter {

    /**
     * metod convert.
     * @param it - incoming Iterator.
     * @return iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> current = it.next();

            @Override
            public boolean hasNext() {
                return it.hasNext() || current.hasNext();
            }

            @Override
            public Integer next() {
                while (it.hasNext() || current.hasNext()) {
                    if (current.hasNext()) {
                        return current.next();
                    } else {
                        current = it.next();
                        return current.next();
                    }
                }
                return -1;
            }
        };
    }
}
