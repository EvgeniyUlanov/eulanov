package ru.job4j.start;

import ru.job4j.models.Item;

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
	private UserAction[] actions = new UserAction[6];

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
	 */
	public void fillActions() {
		this.actions[0] = this.new AddItem();
		this.actions[1] = new MenuTracker.ShowAll();
		this.actions[2] = this.new EditItem();
		this.actions[3] = this.new RemoveItem();
		this.actions[4] = this.new FindItemById();
		this.actions[5] = new FindItemByName();
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
	public void select(String key) {
		if (Integer.valueOf(key) < this.actions.length) {
			this.actions[Integer.valueOf(key) - 1].execute(this.input, this.tracker);
		}
	}

	/**
	 * class AddItem.
	 */
	private class AddItem implements UserAction {
		/**
		 * metod key.
		 * @return key.
		 */
		public String key() {
			return "1";
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

		/**
		 * metod info.
		 * @return string.
		 */
		public String info() {
			return String.format("%s. %s ", this.key(), "Add new Item.");
		}
	}

	/**
	 * class ShowAll.
	 */
	private static class ShowAll implements UserAction {
		/**
		 * metod key.
		 * @return key.
		 */
		public String key() {
			return "2";
		}

		/**
		 * metod execute.
		 * @param input - input.
		 * @param tracker - tracker.
		 */
		public void execute(Input input, Tracker tracker) {
			if (tracker.isNotEmpty()) {
				System.out.println("");
				for (Item item : tracker.findAll()) {
					System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
				}
			} else {
				System.out.println("The list is empty.");
			}
		}

		/**
		 * metod info.
		 * @return string.
		 */
		public String info() {
			return String.format("%s. %s ", this.key(), "Show all Items.");
		}
	}

	/**
	 * class EditItem.
	 */
	private class EditItem implements UserAction {
		/**
		 * metod key.
		 * @return key.
		 */
		public String key() {
			return "3";
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
					item.setCreate(input.ask("enter new create (must be number): "));
					tracker.update(item);
				} else {
					System.out.println("Item with this Id is not exist");
				}
			} else {
				System.out.println("The list is empty.");
			}
		}

		/**
		 * metod info.
		 * @return string.
		 */
		public String info() {
			return String.format("%s. %s ", this.key(), "Edit Item.");
		}
	}

	/**
	 * class RemoveItem.
	 */
	private class RemoveItem implements UserAction {
		/**
		 * metod key.
		 * @return key.
		 */
		public String key() {
			return "4";
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

		/**
		 * metod info.
		 * @return string.
		 */
		public String info() {
			return String.format("%s. %s ", this.key(), "Remove Item.");
		}
	}

	/**
	 * class FindItemById.
	 */
	private class FindItemById implements UserAction {
		/**
		 * metod key.
		 * @return key.
		 */
		public String key() {
			return "5";
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

		/**
		 * metod info.
		 * @return string.
		 */
		public String info() {
			return String.format("%s. %s ", this.key(), "Find Item by Id.");
		}
	}
}

/**
 * class FindItemByName.
 */
class FindItemByName implements UserAction {
	/**
	 * metod key.
	 * @return key.
	 */
	public String key() {
		return "6";
	}

	/**
	 * metod execute.
	 * @param input - input.
	 * @param tracker - tracker.
	 */
	public void execute(Input input, Tracker tracker) {
		if (tracker.isNotEmpty()) {
			Item[] items = tracker.findByName(input.ask("enter name: "));
			if (items.length > 0) {
				for (int i = 0; i < items.length; i++) {
					System.out.println(items[i].getId() + " "
									+ items[i].getName() + " - "
									+ items[i].getDescription());
				}
			} else {
				System.out.println("wrong name.");
			}
		} else {
			System.out.println("The list is empty.");
		}
	}

	/**
	 * metod info.
	 * @return string.
	 */
	public String info() {
		return String.format("%s. %s ", this.key(), "Find Item by Name.");
	}
}