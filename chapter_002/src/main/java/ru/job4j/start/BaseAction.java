package ru.job4j.start;

/**
 * class MenuTracker.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public abstract class BaseAction implements UserAction {
	/** name. */
	private String name;
	/** key. */
	private int key;

	/**
	 * constructor.
	 * @param name - name.
	 * @param key - key.
	 */
	public BaseAction(String name, int key) {
		this.name = name;
		this.key = key;
	}

	/**
	 * metod info.
	 * @return string.
	 */
	public String info() {
		return String.format("%s. %s", this.key, this.name);
	}
}