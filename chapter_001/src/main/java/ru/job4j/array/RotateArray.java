package ru.job4j.array;

/**
 * class Turn.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class RotateArray {

	/**
	 * metod rotate array.
	 *
	 * @param array - start array.
	 * @return rotate array.
	 */

	public int[][] rotate(int[][] array) {
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = i; j < array.length - 1 - i; j++) {
				int temp = array[i][j];
				array[i][j] = array[array.length - j - 1][i];
				array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
				array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
				array[j][array.length - 1 - i] = temp;
			}
		}
		return array;
	}
}