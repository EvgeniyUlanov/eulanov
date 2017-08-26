package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * class SartUI.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class StartUI {
	/** input. */
	private Input input;

	/**
	 * constructor.
	 * @param input - input.
	 */
	public StartUI(Input input) {
		this.input = input;
	}
	/**
	 * main metod.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		StartUI start = new StartUI(input);
		Tracker tracker = new Tracker();
		System.out.println("Tracker - programm for adding and finding task.");
		String userChoice = "";

		while (!userChoice.equals("6")) {
			System.out.println("");
			start.showMenu();
			userChoice = input.ask("Enter your choice: ");

			switch (userChoice) {
				case "0":
					start.createItem(tracker);
					break;

				case "1":
					start.showAll(tracker);
					break;

				case "2":
					start.edit(tracker);
					break;

				case "3":
					start.removeItem(tracker);
					break;
				case "4":
					start.showItemId(tracker);
					break;
				case "5":
					start.showItemName(tracker);
					break;
				case "6":
					System.out.println("Programm out. Good Bay.");
					break;
				default:
					System.out.println("Wrong choice. Try again.");
					break;
			}
		}
	}
	/**
	 * metod showMenu.
	 */
	void showMenu() {
		System.out.println("  Menu");
		System.out.println("0 - Add new Item.");
		System.out.println("1 - Show all Items.");
		System.out.println("2 - Edit Item.");
		System.out.println("3 - Delete Item.");
		System.out.println("4 - Find Item by Id.");
		System.out.println("5 - Find Items by Name.");
		System.out.println("6 - Exit.");
	}

	/**
	 * metod showItem.
	 * @param tracker - tracker.
	 */
	void showItemId(Tracker tracker) {
		if (tracker.isNotEmpty()) {
			Item item = tracker.findById(input.ask("enter Id: "));
			System.out.println("");
			System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
		} else {
			System.out.println("The list is empty.");
		}
	}

	/**
	 * metod add.
	 * @param tracker - tracker.
	 */
	void createItem(Tracker tracker) {
			System.out.println("");
			Item item = new Item(input.ask("enter name: "), input.ask("enter discription: "), 0L);
			tracker.add(item);
	}

	/**
	 * metod showAll.
	 * @param tracker - tracker.
	 */
	void showAll(Tracker tracker) {
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
	 * metod edit.
	 * @param tracker - tracker.
	 */
	void edit(Tracker tracker) {
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
	 * metod removeItem.
	 * @param tracker - tracker.
	 */
	void removeItem(Tracker tracker) {
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
	 * metod showItemName.
	 * @param tracker - tracker.
	 */
	void showItemName(Tracker tracker) {
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
}