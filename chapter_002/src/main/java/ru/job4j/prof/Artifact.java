package ru.job4j.prof;

/**
 * class Artifact.
 * @author Evgeniy Ulanov(komrad1812@yaandex,ru).
 * @version $Id$.
 * @since 0.1
 */

public class Artifact {

	/** name of artifact. */
	private String name;

	/**
	 * constructor for class artifact.
	 * @param name - name of artifact.
	 */
	public Artifact(String name) {
		this.name = name;
	}

	/**
	 * metod returns name of artifact.
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}

}