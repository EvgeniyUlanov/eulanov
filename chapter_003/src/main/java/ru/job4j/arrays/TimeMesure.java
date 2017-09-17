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
		int elementsToDelete = 20000;

		System.out.println("ArrayList test:");
		TimeMesure.timeMesureAddDelete(arrayListTest, elementsToAdd, elementsToDelete);
		System.out.println("LinkedList test:");
		TimeMesure.timeMesureAddDelete(linkedListTest, elementsToAdd, elementsToDelete);
		System.out.println("TreeSet test:");
		TimeMesure.timeMesureAddDelete(treeSetTest, elementsToAdd, elementsToDelete);
	}

	/**
	 * metod mesure time to add many elements(amount).
	 * @param collection - sourse collection.
	 * @param amount - amount of element.
	 */
	public static void add(Collection<String> collection, int amount) {
		for (int i = 0; i < amount; i++) {
			collection.add("Hello" + i);
		}
	}

	/**
	 * metod delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 */
	public static void delete(Collection<String> collection, int amount) {
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
	public static long timeMesureAdd(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		TimeMesure.add(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}

	/**
	 * metod mesure time to delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 * @return long.
	 */
	public static long timeMesureDelete(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		TimeMesure.delete(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}

	/**
	 * metod tests time.
	 * @param collection - collection.
	 * @param amountAdd - amount elements to add
	 * @param amountDelete - amount elements to delete
	 */
	public static void timeMesureAddDelete(Collection<String> collection, int amountAdd, int amountDelete) {
		long resultAdd = 0;
		long resultDelete = 0;
		TimeMesure.timeMesureAdd(collection, amountAdd);
		for (int i = 0; i < 5; i++) {
			collection.clear();
			long tmAdd = TimeMesure.timeMesureAdd(collection, amountAdd);
			long tmDel = TimeMesure.timeMesureDelete(collection, amountDelete);
			if (i > 0) {
				resultAdd += tmAdd;
				resultDelete += tmDel;
			}
		}
		resultAdd /= 4;
		resultDelete /= 4;
		System.out.println(String.format("Add %s elements takes %s milsec", amountAdd, resultAdd));
		System.out.println(String.format("Delete %s elements takes %s milsec", amountDelete, resultDelete));
	}
}