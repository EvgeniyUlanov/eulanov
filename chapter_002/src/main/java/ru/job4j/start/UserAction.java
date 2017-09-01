package ru.job4j.start;

/**
 * Interface UserAction.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public interface UserAction {

	/**
	 * metod key.
	 * @return string.
	 */
	int key();

	/**
	 * metod execute.
	 * @param input - input.
	 * @param tracker - tracker.
	 */
	void execute(Input input, Tracker tracker);

	/**
	 * metod info - shows menu.
	 * @return string.
	 */
	String info();
}