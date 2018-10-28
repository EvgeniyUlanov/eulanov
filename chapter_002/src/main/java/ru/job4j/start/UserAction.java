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
	 * metod execute.
	 * @param tracker - tracker.
	 */
	void execute(Tracker tracker);

	/**
	 * metod info - shows menu.
	 * @return string.
	 */
	String info();
}