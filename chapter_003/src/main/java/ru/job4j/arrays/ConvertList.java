package ru.job4j.arrays;

import java.util.List;
import java.util.ArrayList;

/**
 * class converts list to array.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$.
 * @since 0.1
 */

public class ConvertList {
	/**
	 * method converts array to list.
	 * @param array - array.
	 * @return list.
	 */
	public static List<Integer> toList(int[][] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				list.add(array[i][j]);
			}
		}
		return list;
	}

	/**
	 * method converts list to array.
	 * @param list - list.
	 * @param rows - rows.
	 * @return array[][].
	 */
	public static int[][] listToArray(List<Integer> list, int rows) {
		if (!list.isEmpty()) {
			Integer[] array = list.toArray(new Integer[list.size()]);
			int column = array.length % rows == 0 ? array.length / rows : array.length / rows + 1;
			int[][] result = new int[rows][column];
			int sizeArray = 0;
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i].length; j++) {
					if (sizeArray < array.length && array[sizeArray] != null) {
						result[i][j] = array[sizeArray];
					} else {
						result[i][j] = 0;
					}
					sizeArray++;
				}
			}
			return result;
		}
		return new int[0][0];
	}

	/**
	 * method converts list<int[]> to ArrayList<Integer>.
	 * @param list - list to convert
	 * @return ArrayList<Integer>
	 */
	public static List<Integer> convert(List<int[]> list) {
		if (!list.isEmpty()) {
			List<Integer> result = new ArrayList<>();
			for (int[] array : list) {
				for (int value : array) {
					result.add(value);
				}
			}
			return result;
		}
		return new ArrayList<>();
	}
}