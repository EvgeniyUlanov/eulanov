package ru.job4j.prof;

/**
 * class Human is base class.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Human {
	/** name of human. */
	private String name;
	/** age of human. */
	private int age;
	/** health of human. */
	private int health;

	/**
	 * default constructor for Human.
	 */
	public Human() {

	}

	/**
	 * constructor for Human.
	 * @param name - name of Human.
	 * @param age - age of Human.
	 */
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
		this.health = 100;
	}

	/**
	 * metod use, health decrease.
	 * @param artifact - artifact.
	 */
	public void use(Artifact artifact) {
		System.out.println("Человек использовал предмет " + artifact.getName());
		health -= 10;
	}

	/**
	 * metod getName.
	 * @return - name of Human.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * metod setHealth.
	 * @param health - set health when doctor helps patient.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
}