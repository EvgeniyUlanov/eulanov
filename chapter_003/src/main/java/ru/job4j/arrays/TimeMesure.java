package ru.job4j.arrays;

import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * class for testing how many time takes different collections when they add or delete elements.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$.
 * @since 0.1
 */
public class TimeMesure {

	/**
	 * main metod.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		TimeMesure tm = new TimeMesure();
		Collection<String> arrayListTest = new ArrayList<String>();
		Collection<String> linkedListTest = new LinkedList<String>();
		Collection<String> treeSetTest = new TreeSet<String>();
		long time;
		int elementsToAdd = 999999;
		int elementsToDelete = 50000;

		time = tm.timeMesureAdd(arrayListTest, elementsToAdd);
		System.out.println("ArrayList time add " + elementsToAdd + " elements - " + time + " millisec");
		time = tm.timeMesureAdd(linkedListTest, elementsToAdd);
		System.out.println("LinkedList time add " + elementsToAdd + " elements - " + time + " millisec");
		time = tm.timeMesureAdd(linkedListTest, elementsToAdd);
		System.out.println("TreeSet time add " + elementsToAdd + " elements - " + time + " millisec");

		time = tm.timeMesureDelete(arrayListTest, elementsToDelete);
		System.out.println("ArrayList time delete " + elementsToDelete + " elements - " + time + " millisec");
		time = tm.timeMesureDelete(linkedListTest, elementsToDelete);
		System.out.println("LinkedList time delete " + elementsToDelete + " elements - " + time + " millisec");
		time = tm.timeMesureDelete(treeSetTest, elementsToDelete);
		System.out.println("TreeSet time delete " + elementsToDelete + " elements - " + time + " millisec");
	}

	/**
	 * metod mesure time to add many elements(amount).
	 * @param collection - sourse collection.
	 * @param amount - amount of element.
	 */
	public void add(Collection<String> collection, int amount) {
		for (int i = 0; i < amount; i++) {
			collection.add("Hello" + i);
		}
	}

	/**
	 * metod delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 */
	public void delete(Collection<String> collection, int amount) {
		for (int i = 0; i < amount; i++) {
			collection.remove("Hello" + i);
		}
	}

	/**
	 * metod mesure time to add many elements(amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 * @return long.
	 */
	public long timeMesureAdd(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		this.add(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}

	/**
	 * metod mesure time to delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 * @return long.
	 */
	public long timeMesureDelete(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		this.delete(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}
}