package ru.job4j.array;

/**
 * class BabbleSort sorts array.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {

	/**
	 * metod return sorted array.
	 *
	 * @param array - first array.
	 * @return sorted array.
	 */
	public int[] sort(int[] array) {
		if (array == null) {
			return null;
		}
		for (int i = 1; i != 0;) {
			i = 0;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					i++;
				}
			}
		}
		return array;
	}
}