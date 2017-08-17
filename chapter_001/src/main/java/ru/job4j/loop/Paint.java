package ru.job4j.loop;

/**
 * class Paint create pyramid with height.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

	/**
	 * metod paintBoard return String.
	 * @param height - height of pyramid.
	 * @return string.
	 */
	public String paintPyramid(int height) {
		if (height <= 0) {
		return "height mast be > 0";
		}
		StringBuilder pyramid = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < (2 * height - 1); j++) {
				if (j < (height - 1 - i) || j > (height - 1 + i)) {
					pyramid.append(" ");
				} else {
					pyramid.append("A");
				}
			}
			pyramid.append(System.getProperty("line.separator"));
		}
		return pyramid.toString();
	}
}