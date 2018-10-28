package ru.job4j.compare;

import java.util.Objects;

/**
 * class User.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$.
 * @since 0.1
 */

public class User implements Comparable<User> {
	/** name. */
	private String name;
	/** age. */
	private Integer age;

	/**
	 * constructor.
	 * @param name - name.
	 * @param age - age.
	 */
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * method getAge.
	 * @return age.
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * method getName.
	 * @return name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * method toString.
	 * @return String.
	 */
	@Override
	public String toString() {
		return String.format("User %s - %s", name, age);
	}

	/**
	 * method compareTo.
	 * @param o - user.
	 * @return int.
	 */
	@Override
	public int compareTo(User o) {
		int comAge = this.age.compareTo(o.getAge());
		return comAge != 0 ? comAge : this.name.compareTo(o.getName());
	}

	/**
	 * method equals.
	 * @param o - user.
	 * @return boolean.
	 */
	public boolean equal(User o) {
		return this == o || this.getClass() == o.getClass() && this.name.equals(o.name) && Objects.equals(this.age, o.age);
	}
}