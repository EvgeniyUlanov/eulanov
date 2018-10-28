package ru.job4j.start;

import java.util.ArrayList;
import java.util.List;

/**
 * class SartUI.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */
public class StartUI {
	/** input. */
	private TrackerIO trackerIO;
	/** tracker. */
	private Tracker tracker;
	/** range of valid enter. */
	private List<Integer> range;

	/**
	 * constructor.
	 * @param trackerIO - tracker input/output.
	 * @param tracker - tracker.
	 */
	public StartUI(TrackerIO trackerIO, Tracker tracker) {
		this.trackerIO = trackerIO;
		this.tracker = tracker;
	}

	/**
	 * start metod.
	 */
	public void start() {
		trackerIO.out("");
		trackerIO.out("Tracker - programm for adding and finding task.");
		MenuTracker menu = new MenuTracker(this.tracker);
		this.range = new ArrayList<>();
		int valueOfActions = menu.fillActions();
		for (int i = 0; i <= valueOfActions; i++) {
			range.add(i + 1);
		}
		int key;
		do {
            trackerIO.out("");
			menu.show();
            trackerIO.out("");
			key = trackerIO.in("Enter your choice: ", this.range);
			trackerIO.out("");
			menu.select(key);
		} while (key != 7);
        trackerIO.out("Program out. Good Bay.");
	}

    public void setTrackerIO(TrackerIO trackerIO) {
        this.trackerIO = trackerIO;
    }

    /**
	 * main metod.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Input input = new ValidateInput();
		TrackerIO trackerIO = TrackerIO.getInstance();
		trackerIO.initTrackerIO(System.out::println, input);
		new StartUI(trackerIO, tracker).start();
	}

}