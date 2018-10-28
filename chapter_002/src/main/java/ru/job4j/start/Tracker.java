package ru.job4j.start;

import ru.job4j.models.Item;
import java.util.ArrayList;
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
	private ArrayList<Item> items = new ArrayList<>();
	/** random for Id. */
	private static final Random RN = new Random();

	/**
	 * metod add Item.
	 * @param item - item for add.
	 * @return item - item.
	 */
	public Item add(Item item) {
		item.setId(generateId());
		this.items.add(item);
		return item;
	}

	/**
	 * metod update Item.
	 * @param item - Item for change.
	 */
	public void update(Item item) {
		if (!this.items.isEmpty()) {
			for (int i = 0; i < this.items.size(); i++) {
				if (this.items.get(i).getId().equals(item.getId())) {
					this.items.set(i, item);
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
		if (!this.items.isEmpty()) {
			for (int i = 0; i < this.items.size(); i++) {
				if (this.items.get(i).getId().equals(item.getId())) {
					this.items.remove(i);
					break;
				}
			}
		}
	}

	/**
	 * metod find all Item.
	 * @return Item[].
	 */
	public ArrayList<Item> findAll() {
		if (!this.items.isEmpty()) {
			ArrayList<Item> result = new ArrayList<>();
			for (Item item : this.items) {
				if (item != null) {
					result.add(item);
				}
			}
			return result;
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * metod find all item with name key.
	 * @param key - key to search.
	 * @return Item[].
	 */
	public ArrayList<Item> findByName(String key) {
		if (!this.items.isEmpty()) {
			ArrayList<Item> result = new ArrayList<>();
			for (Item item : this.items) {
				if (item.getName().equals(key)) {
					result.add(item);
				}
			}
			return result;
		}
		return new ArrayList<>();
	}

	/**
	 * metod find item by Id.
	 * @param id - id of Item.
	 * @return Item.
	 */
	public Item findById(String id) {
		if (!this.items.isEmpty()) {
			for (Item item : this.items) {
				if (item.getId().equals(id)) {
					return item;
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
	 * metod isNotEmpty.
	 * @return true if list is not empty.
	 */
	public boolean isNotEmpty() {
		if (items.size() > 0) {
			return true;
		}
		return false;
	}
}