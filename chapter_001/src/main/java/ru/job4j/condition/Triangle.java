package ru.job4j.condition;

/**
 * class Triangle create triangle with 3 point.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Triangle {

	/** point a. */
	private Point a;

	/** point b. */
	private Point b;

	/** point c. */
	private Point c;

	/** distance between ab. */
	private double ab;

	/** distance between bc. */
	private double bc;

	/** distance between ac. */
	private double ac;


	/**
	 * Constructor for class Triangle.
	 * @param a - point a.
	 * @param b - point b.
	 * @param c - point c.
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		ab = distance(a, b);
		bc = distance(b, c);
		ac = distance(a, c);
	}

	/**
	 * metod distance return distance between points.
	 * @param first - point first.
	 * @param second - point second.
	 * @return distance between points
	 */
	public double distance(Point first, Point second) {
		return Math.sqrt(Math.pow((second.getX() - first.getX()), 2)
		               + Math.pow((second.getY() - first.getY()), 2));
	}

	/**
	 * metod halfPerimeter return halfPerimeter of triangle.
	 * @return halfPerimeter
	 */
	public double halfPerimeter() {
		return (this.ab + this.bc + this.ac) / 2;
	}

	/**
	 * metod exist checks exsisting of triangle.
	 * @return exist of triangle.
	 */
	public boolean exist() {
		if ((this.ab + this.bc) > this.ac && (this.bc + this.ac) > this.ab && (this.ab + this.ac) > this.bc) {
			return true;
		}
		return false;
	}

	/**
	 * metod square return area of triangle.
	 * @return square - square.
	 */
	public double square() {
		double hp = this.halfPerimeter();
		if (exist()) {
			return Math.sqrt(hp * (hp - this.ab) * (hp - this.bc) * (hp - this.ac));
		} else {
			return -1;
			}
	}


}