package ru.job4j.prof;

/**
 * class Doctor class extends Human class.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */

public class Doctor extends Human {
	/** speciality of doctor. */
	private String speciality;
	/** qualification of doctor, what he can do. */
	private int qualification;

	/**
	 * default constructor for Doctor.
	 */
	public Doctor() {

	}

	/**
	 * constructor for Doctor.
	 * @param name - name of Doctor.
	 * @param age - age of Doctor.
	 * @param speciality - speciality of Doctor.
	 * @param qualification - how long(age) he works.
	 */
	public Doctor(String name, int age, String speciality, int qualification) {
		super(name, age);
		this.speciality = speciality;
		this.qualification = qualification;
	}

	/**
	 * metod help, human become healthy.
	 * @param patient - human.
	 */
	public void help(Human patient) {
		System.out.println("Доктор " + this.getName() + " лечит " + patient.getName());
		patient.setHealth(100);
	}
}