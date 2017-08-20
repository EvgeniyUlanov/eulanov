package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class RotateArray.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class RotateArrayTest {

	/**
	 * Test for metod rotate
	 * with array 2x2.
	 */
	@Test
	public void whenArrayTwoTwoThenRotateArray() {
		RotateArray array = new RotateArray();
		int[][] startArray = {{1, 2},
							  {3, 4}};
		int[][] result = array.rotate(startArray);
		int[][] expected = {{3, 1},
							{4, 2}};
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod rotate
	 * with array 3x3.
	 */
	@Test
	public void whenArrayThreeThreeThenRotateArray() {
		RotateArray array = new RotateArray();
		int[][] startArray = {{1, 2, 3},
							  {4, 5, 6},
							  {7, 8, 9}};
		int[][] result = array.rotate(startArray);
		int[][] expected = {{7, 4, 1},
							{8, 5, 2},
							{9, 6, 3}};
		assertThat(result, is(expected));
	}
}