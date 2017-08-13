package ru.job4j.calculator;

/**
 * Calculator without main.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {

	/**
	 * result - result.
	 */

    private double result;

    /**
	 * metod add.
	 * @param first - first.
	 * @param second - second.
	 */

	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * metod substruct.
	 * @param first - first.
	 * @param second - second.
	 */

	public void substruct(double first, double second) {
		this.result = first - second;
	}

	/**
	 * metod div.
	 * @param first - first.
	 * @param second - second.
	 */

	public void div(double first, double second) {
		if (second != 0) {
			this.result = first / second;
		} else {
			this.result = 0;
		}
	}

	/**
	 * metod multiple.
	 * @param first - first.
	 * @param second - second.
	 */

	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * metod getResult.
	 * @return result.
	 */

	public double getResult() {
		return this.result;
	}
}