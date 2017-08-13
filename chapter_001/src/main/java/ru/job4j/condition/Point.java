package ru.job4j.condition;

/**
 * condition.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Point {
	/** coord x. */
    private int x;
    /** coord y. */
	private int y;

    /**
	 * constructor.
	 * @param x - coord x.
	 * @param y - coord y.
     */

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * metod getX return x.
     * @return x.
     */

    public int getX() {
	return this.x;
    }

    /**
     * metod getY return y.
     * @return y.
     */

    public int getY() {
	return this.y;
    }

    /**
     * metod is return point belong function.
     * @return x.
	 * @param a - is factor a.
	 * @param b - is factor b.
     */

    public boolean is(int a, int b) {
		return this.y == a * this.x + b;
    }



}