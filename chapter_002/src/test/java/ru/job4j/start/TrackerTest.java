package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.ArrayList;
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
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item("test1", "disc1", 100L));
		items.add(new Item("test2", "disc2", 10L));
		items.add(new Item("test3", "disc3", 20L));
		tracker.add(items.get(0));
		tracker.add(items.get(1));
		tracker.add(items.get(2));
		assertThat(tracker.findAll(), is(items));
	}

	/**
	 * test for metod update, findById.
	 */
	@Test
	public void whenUpdateItemReturnChangedItem() {
		Tracker tracker = new Tracker();
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item("test1", "disc1", 100L));
		items.add(new Item("test2", "disc2", 10L));
		items.add(new Item("test3", "disc3", 20L));
		tracker.add(items.get(0));
		tracker.add(items.get(1));
		tracker.add(items.get(2));
		Item changeItem = new Item("changed", "anotherDisc", 300L);
		changeItem.setId(items.get(1).getId());
		tracker.update(changeItem);
		assertThat(tracker.findById(items.get(1).getId()), is(changeItem));
	}

	/**
	 * test for metod delete.
	 */
	@Test
	public void whenDeleteItemFindAllReturnItemsWithoutItem() {
		Tracker tracker = new Tracker();
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item("test1", "disc1", 100L));
		items.add(new Item("test2", "disc2", 10L));
		items.add(new Item("test3", "disc3", 20L));
		tracker.add(items.get(0));
		tracker.add(items.get(1));
		tracker.add(items.get(2));
		tracker.delete(items.get(1));
		assert (!tracker.findAll().contains(items.get(1)));
	}

	/**
	 * test for metod findByName.
	 */
	@Test
	public void whenItemFindByNameReturnItemFromTracker() {
		Tracker tracker = new Tracker();
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item("test1", "disc1", 100L));
		items.add(new Item("test2", "disc2", 10L));
		items.add(new Item("test3", "disc3", 20L));
		tracker.add(items.get(0));
		tracker.add(items.get(1));
		tracker.add(items.get(2));
		ArrayList<Item> expected = new ArrayList<Item>();
		expected.add(items.get(1));
		assertThat(tracker.findByName("test2"), is(expected));
	}
}