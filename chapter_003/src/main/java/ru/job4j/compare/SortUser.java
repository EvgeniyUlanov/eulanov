package ru.job4j.compare;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;

/**
 * class SortUser.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1
 */

public class SortUser {
	/**
	 * metod sortUser.
	 * @param list - sourseList.
	 * @return set.
	 */
	public static Set<User> sort(List<User> list) {
		Set<User> sortList = new TreeSet<User>();
		sortList.addAll(list);
		return sortList;
	}
}