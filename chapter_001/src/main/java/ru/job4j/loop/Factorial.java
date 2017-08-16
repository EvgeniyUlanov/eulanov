package ru.job4j.loop;

/**
 * class Factorial.
 */

 public class Factorial {

	 /**
	  *
	  * metod retern n!.
	  * @param n - n.
	  * @return - n!.
	  */
	public int calc(int n) {
		if (n == 0) {
			return 1;
		} else {
			int fact = 1;
			for (int i = 1; i <= n; i++) {
				fact = fact * i;
			}
			return fact;
		}
	}
 }