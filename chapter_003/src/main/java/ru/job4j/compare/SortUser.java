package ru.job4j.compare;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Comparator;

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

	/**
	 * metod sortNameLength.
	 * @param list - list.
	 * @return sorted list.
	 */
	public static List<User> sortNameLength(List<User> list) {
		list.sort(
				new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						Integer o1NameL = o1.getName().length();
						Integer o2NameL = o2.getName().length();
						return o1NameL.compareTo(o2NameL);
					}
				}
		);
		return list;
	}

	/**
	 * metod sortByNameAge.
	 * @param list - list.
	 * @return sorted list
	 */
	public static List<User> sortByNameByAge(List<User> list) {
		list.sort(
				new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						int compareName = o1.getName().compareTo(o2.getName());
						Integer o1Age = o1.getAge();
						Integer o2Age = o2.getAge();
						return compareName == 0 ? o1Age.compareTo(o2Age) : compareName;
					}
				}
		);
		return list;
	}
}