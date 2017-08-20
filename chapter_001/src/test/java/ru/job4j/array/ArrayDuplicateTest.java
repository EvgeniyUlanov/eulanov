package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class ArrayDuplicate.
 *
 * @author Evgeniy Ulanov.
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {

	/**
	 * test for metod remove.
	 * with two uniqe strings.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithTwoUniqueStrings() {
		ArrayDuplicate array = new ArrayDuplicate();
		String[] strings = {"One", "Two", "One", "Two", "One", "Two"};
		String[] result = array.remove(strings);
		String[] expected = {"One", "Two"};
		assertThat(result, is(expected));
	}

	/**
	 * test for metod remove.
	 * with one unique strings.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithOneString() {
		ArrayDuplicate array = new ArrayDuplicate();
		String[] strings = {"One", "One", "One", "One", "One", "One"};
		String[] result = array.remove(strings);
		String[] expected = {"One"};
		assertThat(result, is(expected));
	}

	/**
	 * test for metod remove.
	 * with five unique strings.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithFiveUniqueStrings() {
		ArrayDuplicate array = new ArrayDuplicate();
		String[] strings = {"One", "Two", "Free", "One", "Free", "Two", "Four", "Four", "Five"};
		String[] result = array.remove(strings);
		String[] expected = {"One", "Two", "Free", "Five", "Four"};
		assertThat(result, is(expected));
	}
}