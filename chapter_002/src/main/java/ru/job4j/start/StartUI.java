package ru.job4j.start;

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
		System.out.println("");
		System.out.println("Tracker - programm for adding and finding task.");
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillActions();
		String key = "";
		do {
			System.out.println("");
			menu.show();
			System.out.println("");
			key = input.ask("Enter your choice: ");
			System.out.println("");
			menu.select(key);
		} while (!key.equals("7"));
		System.out.println("Programm out. Good Bay.");
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

}