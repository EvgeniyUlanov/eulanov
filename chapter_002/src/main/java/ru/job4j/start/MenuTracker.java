package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.ArrayList;

/**
 * class MenuTracker.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {

	/** input. */
	private Input input;

	/** tracker. */
	private Tracker tracker;

	/** userActions. */
	private ArrayList<UserAction> actions = new ArrayList<UserAction>();

	/**
	 * constructor.
	 * @param input - input.
	 * @param tracker - tracker.
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * metod fill Actions.
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
			System.out.println(action.info());
		}
		System.out.println(String.format("7. %s ", "Exit."));
	}

	/**
	 * metod select user choice.
	 * @param key - user select.
	 */
	public void select(int key) {
		if (key - 1 < this.actions.size()) {
			this.actions.get(key - 1).execute(this.input, this.tracker);
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
		 * metod execute.
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			Item item = new Item(input.ask("enter name: "), input.ask("enter discription: "), 0L);
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
		 * metod execute.
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			ArrayList<Item> allItems = tracker.findAll();
			if (!allItems.isEmpty()) {
				System.out.println("");
				for (Item item : allItems) {
					System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
				}
			} else {
				System.out.println("The list is empty.");
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
		 * metod execute.
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			if (tracker.isNotEmpty()) {
				System.out.println("");
				String answer = input.ask("enter id: ");
				Item item = tracker.findById(answer);
				if (item.getId() != null) {
					item.setName(input.ask("enter new name: "));
					item.setDescription(input.ask("enter new description: "));
					// Проверка что введено число.
					boolean invalide = true;
					do {
						try {
							item.setCreate(input.ask("enter new create (must be number): "));
							invalide = false;
						} catch (NumberFormatException nfe) {
							System.out.println("It must be natural value.");
						}
					} while (invalide);
					// если все нормально создаем Item.
					//tracker.update(item);
				} else {
					System.out.println("Item with this Id is not exist");
				}
			} else {
				System.out.println("The list is empty.");
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
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			if (tracker.isNotEmpty()) {
				System.out.println("");
				String answer = input.ask("enter id: ");
				Item item = tracker.findById(answer);
				if (item.getId() != null) {
					tracker.delete(item);
				} else {
					System.out.println("Item with this Id is not exist");
				}
			} else {
				System.out.println("The list is empty.");
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
		 * metod execute.
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			if (tracker.isNotEmpty()) {
				Item item = tracker.findById(input.ask("enter Id: "));
				System.out.println("");
				System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
			} else {
				System.out.println("The list is empty.");
			}
		}
	}
}

/**
 * class FindItemByName.
 */
class FindItemByName extends BaseAction {
	/**
	 * constructor.
	 * @param name - name.
	 * @param key - key..
	 */
	FindItemByName(String name, int key) {
		super(name, key);
	}

	/**
	 * metod execute.
	 * @param input - input.
	 * @param tracker - tracker.
	 */
	public void execute(Input input, Tracker tracker) {
		ArrayList<Item> items = tracker.findByName(input.ask("enter name: "));
		if (items.size() == 0) {
			System.out.println("No items found with this name.");
		} else if (items.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				System.out.println(String.format("%s %s - %s", items.get(i).getId(), items.get(i).getName(),
								items.get(i).getDescription()));
			}
		} else {
			System.out.println("wrong name.");
		}
	}
}