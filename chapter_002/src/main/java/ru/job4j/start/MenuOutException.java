package ru.job4j.start;

/**
 * class MenuOutException.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class MenuOutException extends RuntimeException {
	/** Constructor.
	 * @param msg - message.
	 */
	public MenuOutException(String msg) {
		super(msg);
	}
}