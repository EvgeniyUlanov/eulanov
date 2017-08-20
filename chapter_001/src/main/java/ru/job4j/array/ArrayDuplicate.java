package ru.job4j.array;

import java.util.Arrays;
/**
 * class ArrayDuplicate.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {

	/**
	 * metod remove returns array without repeat.
	 * @param array - start array.
	 * @return - finish array.
	 */
	public String[] remove(String[] array) {
		String temp;
		int count = 0;
		for (int i = 0; i < array.length - count; i++) {
			for (int j = i + 1; j < array.length - count; j++) {
				while (array[i].equals(array[j]) && j < array.length - count) {
					count++;
					if (array.length - count != j) {
					temp = array[array.length - count];
					array[array.length - count] = array[j];
					array[j] = temp;
					}
				}
			}
		}
		return Arrays.copyOf(array, array.length - count);
	}
}