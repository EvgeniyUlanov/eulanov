package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Turn.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {

	/**
	 * Test for metod back.
	 * if array {5}.
	 */
	@Test
	public void whenArrayHaveOneElement() {
		Turn array = new Turn();
		int[] startArray = {5};
		int[] result = array.back(startArray);
		int[] expected = {5};
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod back.
	 * if array null.
	 */
	@Test
	public void whenArrayDontHaveElements() {
		Turn array = new Turn();
		int[] startArray = null;
		int[] result = array.back(startArray);
		int[] expected = null;
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod back.
	 * if array have odd size.
	 */
	@Test
	public void whenArrayHaveOddsize() {
		Turn array = new Turn();
		int[] startArray = {1, 2, 3, 4, 5};
		int[] result = array.back(startArray);
		int[] expected = {5, 4, 3, 2, 1};
		assertThat(result, is(expected));
	}

	/**
	 * Test for metod back.
	 * if array have even size.
	 */
	@Test
	public void whenArrayHaveEvenSize() {
		Turn array = new Turn();
		int[] startArray = {3, 2, 5, 1};
		int[] result = array.back(startArray);
		int[] expected = {1, 5, 2, 3};
		assertThat(result, is(expected));
	}
}