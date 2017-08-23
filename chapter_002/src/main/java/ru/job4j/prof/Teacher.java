package ru.job4j.prof;

/**
 * class Teacher class extends Human class.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Teacher extends Human {
	/** speciality of teacher. */
	private String speciality;
	/** expirience of teacher, shows how long he works. */
	private int expirience;

	/**
	 * default constructor for Teacher.
	 */
	public Teacher() {

	}

	/**
	 * constructor for Teacher.
	 * @param name - name of Teacher.
	 * @param age - age of Teacher.
	 * @param speciality - speciality of Theacher, what he teach.
	 * @param expirience - how long(age) he works.
	 */
	public Teacher(String name, int age, String speciality, int expirience) {
		super(name, age);
		this.speciality = speciality;
		this.expirience = expirience;
	}

	/**
	 * metod teach, human become specialist.
	 * @param student - human.
	 */
	public void teach(Human student) {
		System.out.println("Учитель " + this.getName() + " учит " + student.getName());
	}
}