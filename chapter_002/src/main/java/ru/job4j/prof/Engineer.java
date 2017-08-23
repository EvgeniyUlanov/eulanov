package ru.job4j.prof;

/**
 * class Engineer class extends Human class.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Engineer extends Human {
	/** qualification of engineer. */
	private String qualification;
	/** expirience of engineer. */
	private int expirience;
	/** rang og engineer. */
	private int rang;

	/**
	 * default constructor for Doctor.
	 */
	public Engineer() {

	}

	/**
	 * constructor for Engineer.
	 * @param name - name of Engineer.
	 * @param age - age of Engineer.
	 * @param qualification - qualification of Engineer.
	 * @param expirience - how long(age) he works.
	 * @param rang - rang of Engineer.
	 */
	public Engineer(String name, int age, String qualification, int expirience, int rang) {
		super(name, age);
		this.qualification = qualification;
		this.expirience = expirience;
		this.rang = rang;
	}

	/**
	 * metod create, engineer create artifacts.
	 * @return artifact - artifact.
	 */
	public Artifact create() {
		System.out.println("Инженер " + this.getName() + " создал предмет");
		Artifact artifact = new Artifact("артифакт");
		return artifact;
	}
}