package ru.job4j.models;

/**
 * class Item.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Item {
	/** id of Item. */
	private String id;
	/** name of Item. */
	private String name;
	/** description of Item. */
	private String description;
	/** create. */
	private long create;

	/** default constructor for class Item. */
	public Item() {
	}

	/**
	 * constructor for class Item.
	 * @param name - name of Item.
	 * @param description - description of Item.
	 * @param create - create.
	 */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}

	/**
	 * getId.
	 * @return id of Item.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * setId.
	 * @param id - id for Item.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * getName.
	 * @return name of Item.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setName.
	 * @param name - new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getDescription.
	 * @return description of Item.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * setDescription.
	 * @param description - new description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getCreate.
	 * @return create.
	 */
	public long getCreate() {
		return this.create;
	}

	/**
	 * setCreate.
	 * @param create - new create.
	 */
	public void setCreate(String create) {
		this.create = Long.parseLong(create);
	}
}

