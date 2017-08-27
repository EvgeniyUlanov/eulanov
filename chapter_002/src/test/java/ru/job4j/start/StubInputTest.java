package ru.job4j.start;

import ru.job4j.models.Item;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class StubInputTest.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class StubInputTest {

	/**
	 * test adding Items.
	 */
	@Test
	public void whenUserAddItemThenTrackerHasThisItem() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "new test", "description", "6"});
		new StartUI(input, tracker).start();
		assertThat(tracker.findAll()[0].getName(), is("new test"));
	}

	/**
	 * test deleting Items.
	 */
	@Test
	public void whenUserDeleteItemThenTrackerIsEmpty() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "disc1", 0L);
		tracker.add(item);
		String id = item.getId();
		Input input = new StubInput(new String[] {"3", id, "6"});
		new StartUI(input, tracker).start();
		assertThat(tracker.isNotEmpty(), is(false));
	}

	/**
	 * test updating Items.
	 */
	@Test
	public void whenUserUpdateItemThenTrackerHaveUpdateItem() {
		Tracker tracker = new Tracker();
		Item item = new Item("test1", "disc1", 0L);
		tracker.add(item);
		String id = item.getId();
		Input input = new StubInput(new String[] {"2", id, "update task",
												  "update task", "100", "6"});
		new StartUI(input, tracker).start();
		assertThat(tracker.findById(id).getName(), is("update task"));
	}
}