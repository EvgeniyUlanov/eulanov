package ru.job4j.hashmap;

import java.util.List;
import java.util.HashMap;

/**
 * class UserConvert.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class UserConvert {
	/**
	 * method process.
	 * @param list - list.
	 * @return HashMap.
	 */
	public static HashMap<Integer, User> process(List<User> list) {
		HashMap<Integer, User> result = new HashMap<>();
		for (User user : list) {
			result.put(user.getId(), user);
		}
		return result;
	}
}