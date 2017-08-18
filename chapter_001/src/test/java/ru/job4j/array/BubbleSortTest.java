package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class BubbleSort.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {

	/**
	 * Test array with ten elements.
	 */
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort array = new BubbleSort();
		int[] startArray = {5, 1, 8, 2, 9, 6, 4, 3, 1, 7};
		int[] result = array.sort(startArray);
		int[] expected = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertThat(result, is(expected));
	}

	/**
	 * Test empty array.
	 */
	@Test
	public void whenArrayWithoutElements() {
		BubbleSort array = new BubbleSort();
		int[] startArray = null;
		int[] result = array.sort(startArray);
		int[] expected = null;
		assertThat(result, is(expected));
	}
}