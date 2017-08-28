package ru.job4j.strategy;

/**
 * class Paint.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class Paint {
	/** shape. */
	private Shape shape;

	/**
	 * constructor for class Paint.
	 * @param shape - shape.
	 */
	public Paint(Shape shape) {
		this.shape = shape;
	}

	/**
	 * metod draw.
	 */
	public void draw() {
		System.out.print(this.shape.pic());
	}
}