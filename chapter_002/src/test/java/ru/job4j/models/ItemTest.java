package ru.job4j.models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ItemTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

 public class ItemTest {
	/**
	 * test metod getName.
	 */

	@Test
	public void whenItemCreateGetNameReturnName() {
		Item item = new Item("cont", "discription", 100L);
		assertThat(item.getName(), is("cont"));
	}

	/**
	 * test metod setId and getId.
	 */

	@Test
	public void whenItemCreateSetIdGetIdReturnId() {
		Item item = new Item("cont", "discription", 100L);
		item.setId("1548754");
		assertThat(item.getId(), is("1548754"));
	}

	/**
	 * test metod getDescription.
	 */

	@Test
	public void whenItemCreateGetDescriptionReternDescription() {
		Item item = new Item("cont", "discription", 100L);
		assertThat(item.getDescription(), is("discription"));
	}

	/**
	 * test metod getCreate.
	 */

	@Test
	public void whenItemCreateGetCreateReturnCreate() {
		Item item = new Item("cont", "discription", 100L);
		assertThat(item.getCreate(), is(100L));
	}

}