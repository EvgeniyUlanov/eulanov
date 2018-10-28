package ru.job4j.hashmap;

/**
 * class User.
 */

public class User {
	/** id.*/
	private int id;
	/** name.*/
	private String name;
	/** city.*/
	private String city;

	/**
	 * constructor.
	 * @param name - name.
	 * @param city - city.
	 */
	public User(String name, String city) {
		this.name = name;
		this.city = city;
	}

	/**
	 * method setId.
	 * @param id - id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * metod getId.
	 * @return id.
	 */
	public int getId() {
		return id;
	}
}
