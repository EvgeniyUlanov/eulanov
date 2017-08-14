package ru.job4j.max;

/**
 * Max.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * metod max reterns max value of first, second.
     * @param first - first.
     * @param second - second.
     * @return max value.
     */

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * metod max reterns max value of three.
     * @param first - first.
     * @param second - second.
     * @param third - third.
     * @return max value.
     */

    public int maxOfThree(int first, int second, int third) {
	int value = max(first, second);
	value = max(value, third);
	return value;
    }

}