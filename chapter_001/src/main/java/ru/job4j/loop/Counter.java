package ru.job4j.loop;

/**
 * class Counter made sum of even numbers.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Counter {

	/**
	 * metod add rturn sum of even numbers.
	 * @param start - start number.
	 * @param finish - finish number.
	 * @return sum.
	 */
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
			sum = sum + i;
			}
		}
		return sum;
	}
}