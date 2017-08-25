package ru.job4j.start;

import ru.job4j.models.Item;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TrackerTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

 public class TrackerTest {

	/**
	 * test for metod add, findAll, generateId.
	 */
	@Test
	public void whenItemAddReturnItems() {
		Tracker tracker = new Tracker();
		Item[] items = {new Item("test1", "disc1", 100L),
					    new Item("test2", "disc2", 10L),
						new Item("test3", "disc3", 20L)
						};
		tracker.add(items[0]);
		tracker.add(items[1]);
		tracker.add(items[2]);
		assertThat(tracker.findAll(), is(items));
	}

	/**
	 * test for metod update, findById.
	 */
	@Test
	public void whenUpdateItemReturnChangedItem() {
		Tracker tracker = new Tracker();
		Item[] items = {new Item("test1", "disc1", 100L),
					    new Item("test2", "disc2", 10L),
						new Item("test3", "disc3", 20L)
						};
		tracker.add(items[0]);
		tracker.add(items[1]);
		tracker.add(items[2]);
		Item changeItem = new Item("changed", "anotherDisc", 300L);
		changeItem.setId(items[1].getId());
		tracker.update(changeItem);
		assertThat(tracker.findById(items[1].getId()), is(changeItem));
	}

	/**
	 * test for metod delete.
	 */
	@Test
	public void whenDeleteItemFindAllReturnItemsWithoutItem() {
		Tracker tracker = new Tracker();
		Item[] items = {new Item("test1", "disc1", 100L),
					    new Item("test2", "disc2", 10L),
						new Item("test3", "disc3", 20L)
						};
		tracker.add(items[0]);
		tracker.add(items[1]);
		tracker.add(items[2]);
		Item[] itemsAfterDelete = {items[0], items[2]};
		tracker.delete(items[1]);
		assertThat(tracker.findAll(), is(itemsAfterDelete));
	}

	/**
	 * test for metod findByName.
	 */
	@Test
	public void whenItemFindByNameReturnItemFromTracker() {
		Tracker tracker = new Tracker();
		Item[] items = {new Item("test1", "disc1", 100L),
					    new Item("test2", "disc2", 10L),
						new Item("test3", "disc3", 20L)
						};
		tracker.add(items[0]);
		tracker.add(items[1]);
		tracker.add(items[2]);
		Item[] expected = {items[1]};
		assertThat(tracker.findByName("test2"), is(expected));
	}
}