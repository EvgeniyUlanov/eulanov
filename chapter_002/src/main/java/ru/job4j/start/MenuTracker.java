package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * class MenuTracker.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {

	/** input. */
	private TrackerIO trackerIO;
	/** tracker. */
	private Tracker tracker;
	/** userActions. */
	private ArrayList<UserAction> actions = new ArrayList<>();

	/**
	 * constructor.
	 * @param tracker - tracker.
	 */
	public MenuTracker(Tracker tracker) {
		trackerIO = TrackerIO.getInstance();
		this.tracker = tracker;
	}

	/**
	 * method fill Actions.
	 * @return actions size.
	 */
	public Integer fillActions() {
		this.actions.add(this.new AddItem("Add new Item.", 1));
		this.actions.add(new MenuTracker.ShowAll("Show All Items", 2));
		this.actions.add(this.new EditItem("Edit Item.", 3));
		this.actions.add(this.new RemoveItem("Remove Item.", 4));
		this.actions.add(this.new FindItemById("Find Item by Id.", 5));
		this.actions.add(new FindItemByName("Find Item by Name.", 6));
		return actions.size();
	}

	/**
	 * metod show - shows menu.
	 */
	public void show() {
		for (UserAction action : this.actions) {
			trackerIO.out(action.info());
		}
		trackerIO.out(String.format("7. %s ", "Exit."));
	}

	/**
	 * method select user choice.
	 * @param key - user select.
	 */
	public void select(int key) {
		if (key - 1 < this.actions.size()) {
			this.actions.get(key - 1).execute(this.tracker);
		}
	}

	/**
	 * class AddItem.
	 */
	private class AddItem extends BaseAction {
		/**
		 * constructor.
		 * @param name - name.
		 * @param key - key.
		 */
		AddItem(String name, int key) {
			super(name, key);
		}

		/**
		 * method execute.
		 * @param tracker - tracker.
		 */
		public void execute(Tracker tracker) {
			Item item = new Item(trackerIO.in("enter name: "), trackerIO.in("enter discription: "), 0L);
			tracker.add(item);
		}
	}

	/**
	 * class ShowAll.
	 */
	private static class ShowAll extends BaseAction {
		/**
		 * constructor.
		 * @param name - name.
		 * @param key - key..
		 */
		ShowAll(String name, int key) {
			super(name, key);
		}

		/**
		 * method execute.
		 * @param tracker - tracker.
		 */
		public void execute(Tracker tracker) {
			ArrayList<Item> allItems = tracker.findAll();
			if (!allItems.isEmpty()) {
				TrackerIO.getInstance().out("");
				for (Item item : allItems) {
					TrackerIO.getInstance().out(item.getId() + " " + item.getName() + " - " + item.getDescription());
				}
			} else {
				TrackerIO.getInstance().out("The list is empty.");
			}
		}
	}

	/**
	 * class EditItem.
	 */
	private class EditItem extends BaseAction {
		/**
		 * constructor.
		 * @param name - name.
		 * @param key - key..
		 */
		EditItem(String name, int key) {
			super(name, key);
		}

		/**
		 * method execute.
		 * @param tracker - tracker.
		 */
		public void execute(Tracker tracker) {
			if (tracker.isNotEmpty()) {
				trackerIO.out("");
				String answer = trackerIO.in("enter id: ");
				Item item = tracker.findById(answer);
				if (item.getId() != null) {
					item.setName(trackerIO.in("enter new name: "));
					item.setDescription(trackerIO.in("enter new description: "));
					boolean invalid = true;
					do {
						try {
							item.setCreate(trackerIO.in("enter new create (must be number): "));
							invalid = false;
						} catch (NumberFormatException nfe) {
							trackerIO.out("It must be natural value.");
						}
					} while (invalid);
				} else {
					trackerIO.out("Item with this Id is not exist");
				}
			} else {
				trackerIO.out("The list is empty.");
			}
		}
	}

	/**
	 * class RemoveItem.
	 */
	private class RemoveItem extends BaseAction {
		/**
		 * constructor.
		 * @param name - name.
		 * @param key - key..
		 */
		RemoveItem(String name, int key) {
			super(name, key);
		}

		/**
		 * metod execute.
		 * @param tracker - tracker.
		 */
		public void execute(Tracker tracker) {
			if (tracker.isNotEmpty()) {
				trackerIO.out("");
				String answer = trackerIO.in("enter id: ");
				Item item = tracker.findById(answer);
				if (item.getId() != null) {
					tracker.delete(item);
				} else {
					trackerIO.out("Item with this Id is not exist");
				}
			} else {
				trackerIO.out("The list is empty.");
			}
		}
	}

	/**
	 * class FindItemById.
	 */
	private class FindItemById extends BaseAction {
		/**
		 * constructor.
		 * @param name - name.
		 * @param key - key..
		 */
		FindItemById(String name, int key) {
			super(name, key);
		}

		/**
		 * method execute.
		 * @param tracker - tracker.
		 */
		public void execute(Tracker tracker) {
			if (tracker.isNotEmpty()) {
				Item item = tracker.findById(trackerIO.in("enter Id: "));
				trackerIO.out("");
				trackerIO.out(item.getId() + " " + item.getName() + " - " + item.getDescription());
			} else {
				trackerIO.out("The list is empty.");
			}
		}
	}
}

/**
 * class FindItemByName.
 */
class FindItemByName extends BaseAction {

	private TrackerIO trackerIO;

	/**
	 * constructor.
	 * @param name - name.
	 * @param key - key..
	 */
	FindItemByName(String name, int key) {
		super(name, key);
		trackerIO = TrackerIO.getInstance();
	}

	/**
	 * metod execute.
	 * @param tracker - tracker.
	 */
	public void execute(Tracker tracker) {
		List<Item> items = tracker.findByName(trackerIO.in("enter name: "));
		if (items.size() == 0) {
			trackerIO.in("No items found with this name.");
		} else {
			for (Item item : items) {
				trackerIO.out(String.format("%s %s - %s", item.getId(), item.getName(),
						item.getDescription()));
			}
		}
	}
}