package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.Arrays;
import java.util.Random;

/**
 * class Tracker.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Tracker {

	/** Item[]. */
	private Item[] items = new Item[10];
	/** position - size of Item[] without null. */
	private int position = 0;
	/** random for Id. */
	private static final Random RN = new Random();

	/**
	 * metod add Item.
	 * @param item - item for add.
	 */
	public void add(Item item) {
		item.setId(generateId());
		this.items[this.position++] = item;
	}

	/**
	 * metod update Item.
	 * @param item - Item for change.
	 */
	public void update(Item item) {
		if (isNotEmpty()) {
			for (int i = 0; i < this.position; i++) {
				if (this.items[i].getId().equals(item.getId())) {
					this.items[i] = item;
					break;
				}
			}
		}
	}

	/**
	 * metod delete.
	 * @param item - item to delete.
	 */
	public void delete(Item item) {
		if (isNotEmpty()) {
			for (int i = 0; i < this.position; i++) {
				if (this.items[i].getId().equals(item.getId())) {
					this.items[i] = this.items[this.position - 1];
					break;
				}
			}
			this.items = Arrays.copyOf(this.items, --this.position);
		}
	}

	/**
	 * metod find all Item.
	 * @return Item[].
	 */
	public Item[] findAll() {
		if (isNotEmpty()) {
			Item[] result = new Item[this.position];
			for (int index = 0; index < this.position; index++) {
				result[index] = this.items[index];
			}
			return result;
		} else {
			return new Item[0];
		}
	}

	/**
	 * metod find all item with name key.
	 * @param key - key to search.
	 * @return Item[].
	 */
	public Item[] findByName(String key) {
		Item[] result = new Item[this.position - 1];
		int count = 0;
		for (int i = 0; i < position; i++) {
			if (this.items[i].getName().equals(key)) {
				result[count++] = this.items[i];
			}
		}
		return Arrays.copyOf(result, count);
	}

	/**
	 * metod find item by Id.
	 * @param id - id of Item.
	 * @return Item.
	 */
	public Item findById(String id) {
		if (isNotEmpty()) {
			for (int i = 0; i < position; i++) {
				if (this.items[i].getId().equals(id)) {
					return this.items[i];
				}
			}
		}
		return new Item("Item with this Id is not exist", "", 0L);
	}

	/**
	 * metod generateId.
	 * @return Id.
	 */
	public String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

	/**
	 * metod isEmpty.
	 * @return true if items list is empty.
	 */
	public boolean isNotEmpty() {
		return this.position > 0;
	}
}