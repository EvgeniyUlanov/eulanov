package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.ArrayList;
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
		ArrayList<String> answers = new ArrayList<>();
		answers.add("1");
		answers.add("new test");
		answers.add("description");
		answers.add("7");
		Input input = new StubInput(answers);
		TrackerIO trackerIO = TrackerIO.getInstance();
		trackerIO.initTrackerIO(System.out::println, input);
		new StartUI(trackerIO, tracker).start();
		assertThat(tracker.findAll().get(0).getName(), is("new test"));
	}

	/**
	 * test deleting Items.
	 */
	@Test
	public void whenUserDeleteItemThenTrackerIsEmpty() {
		Tracker tracker = new Tracker();
		ArrayList<String> answers = new ArrayList<>();
		Item item = new Item("test1", "disc1", 0L);
		tracker.add(item);
		String id = item.getId();
		answers.add("4");
		answers.add(id);
		answers.add("7");
		Input input = new StubInput(answers);
		TrackerIO trackerIO = TrackerIO.getInstance();
		trackerIO.initTrackerIO(System.out::println, input);
		new StartUI(trackerIO, tracker).start();
		assertThat(tracker.isNotEmpty(), is(false));
	}

	/**
	 * test updating Items.
	 */
	@Test
	public void whenUserUpdateItemThenTrackerHaveUpdateItem() {
		Tracker tracker = new Tracker();
		ArrayList<String> answers = new ArrayList<>();
		Item item = new Item("test1", "disc1", 0L);
		tracker.add(item);
		String id = item.getId();
		answers.add("3");
		answers.add(id);
		answers.add("update task");
		answers.add("update task");
		answers.add("100");
		answers.add("7");
		Input input = new StubInput(answers);
		TrackerIO trackerIO = TrackerIO.getInstance();
		trackerIO.initTrackerIO(System.out::println, input);
		new StartUI(trackerIO, tracker).start();
		assertThat(tracker.findById(id).getName(), is("update task"));
	}
}