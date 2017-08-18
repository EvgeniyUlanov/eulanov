package ru.job4j.array;

/**
 * class Turn.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

 public class Turn {

	/**
	 * metos back return flip array.
	 * @param array - first array.
	 * @return flip array.
	 */
	public int[] back(int[] array) {
		if (array == null) {
			return null;
		}
		for (int i = 0; i < (array.length / 2); i++) {
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		return array;
	}
}