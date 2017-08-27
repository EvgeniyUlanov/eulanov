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
	/** tracker. */
	private Tracker tracker;

	/**
	 * constructor.
	 * @param input - input.
	 * @param tracker - tracker.
	 */
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * start metod.
	 */
	public void start() {
		System.out.println("Tracker - programm for adding and finding task.");
		String userChoice = "";
		while (!userChoice.equals("6")) {
			System.out.println("");
			showMenu();
			userChoice = input.ask("Enter your choice: ");

			switch (userChoice) {
				case "0":
					createItem();
					break;

				case "1":
					showAll();
					break;

				case "2":
					edit();
					break;

				case "3":
					removeItem();
					break;
				case "4":
					showItemId();
					break;
				case "5":
					showItemName();
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
	 * main metod.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		//Tracker tracker = new Tracker();
		//Input input = new ConsoleInput();
		//new StartUI(input, tracker).start();
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
	 */
	void showItemId() {
		if (tracker.isNotEmpty()) {
			Item item = this.tracker.findById(input.ask("enter Id: "));
			System.out.println("");
			System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
		} else {
			System.out.println("The list is empty.");
		}
	}

	/**
	 * metod add.
	 */
	void createItem() {
			System.out.println("");
			Item item = new Item(input.ask("enter name: "), input.ask("enter discription: "), 0L);
			this.tracker.add(item);
	}

	/**
	 * metod showAll.
	 */
	void showAll() {
		if (this.tracker.isNotEmpty()) {
			System.out.println("");
			for (Item item : this.tracker.findAll()) {
				System.out.println(item.getId() + " " + item.getName() + " - " + item.getDescription());
			}
		} else {
			System.out.println("The list is empty.");
		}
	}

	/**
	 * metod edit.
	 */
	void edit() {
		if (this.tracker.isNotEmpty()) {
			System.out.println("");
			String answer = input.ask("enter id: ");
			Item item = this.tracker.findById(answer);
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
	 */
	void removeItem() {
		if (this.tracker.isNotEmpty()) {
			System.out.println("");
			String answer = input.ask("enter id: ");
			Item item = this.tracker.findById(answer);
			if (item.getId() != null) {
				this.tracker.delete(item);
			} else {
				System.out.println("Item with this Id is not exist");
			}
		} else {
			System.out.println("The list is empty.");
		}
	}

	/**
	 * metod showItemName.
	 */
	void showItemName() {
		if (this.tracker.isNotEmpty()) {
			Item[] items = this.tracker.findByName(input.ask("enter name: "));
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