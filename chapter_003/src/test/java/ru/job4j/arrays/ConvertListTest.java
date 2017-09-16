package ru.job4j.arrays;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class FigureTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

 public class ConvertListTest {

	/**
	 * test convert array to list.
	 */
	@Test
	public void whenSourseArrayThanReturnList() {
		int[][] sourseArray = {{1, 2}, {3, 4}};
		List<Integer> compareList = new ArrayList<>();
		compareList.add(1);
		compareList.add(2);
		compareList.add(3);
		compareList.add(4);
		List<Integer> result = new ArrayList<>();
		result = ConvertList.toList(sourseArray);
		assertThat(result, is(compareList));
	}

	/**
	 * test convert list to array.
	 */
	@Test
	public void whenSorseListThanReturnArray() {
		List<Integer> sourseList = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			sourseList.add(i);
		}
		int[][] result = ConvertList.listToArray(sourseList, 3);
		int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
		assertThat(result, is(expected));
	}
}