package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
                boolean result = false;
                while (it.hasNext() || current.hasNext()) {
                    if (current.hasNext()) {
                        result = true;
                        break;
                    } else {
                        current = it.next();
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                Integer result = null;
                while (it.hasNext() || current.hasNext()) {
                    if (current.hasNext()) {
                        result = current.next();
                        break;
                    } else {
                        current = it.next();
                    }
                }
                if (result == null) {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}
