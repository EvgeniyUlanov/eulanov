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
public class TimeMeasure {

	/**
	 * main method.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		Collection<String> arrayListTest = new ArrayList<String>();
		Collection<String> linkedListTest = new LinkedList<String>();
		Collection<String> treeSetTest = new TreeSet<String>();
		int elementsToAdd = 999999;
		int elementsToDelete = 20000;

		System.out.println("ArrayList test:");
		TimeMeasure.timeMeasureAddDelete(arrayListTest, elementsToAdd, elementsToDelete);
		System.out.println("LinkedList test:");
		TimeMeasure.timeMeasureAddDelete(linkedListTest, elementsToAdd, elementsToDelete);
		System.out.println("TreeSet test:");
		TimeMeasure.timeMeasureAddDelete(treeSetTest, elementsToAdd, elementsToDelete);
	}

	/**
	 * method measure time to add many elements(amount).
	 * @param collection - source collection.
	 * @param amount - amount of element.
	 */
	public static void add(Collection<String> collection, int amount) {
		for (int i = 0; i < amount; i++) {
			collection.add("Hello" + i);
		}
	}

	/**
	 * method delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 */
	public static void delete(Collection<String> collection, int amount) {
		for (int i = 0; i < amount; i++) {
			collection.remove("Hello" + i);
		}
	}

	/**
	 * method measure time to add many elements(amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 * @return long.
	 */
	public static long timeMeasureAdd(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		TimeMeasure.add(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}

	/**
	 * method measure time to delete many elements(from begin to amount).
	 * @param collection - collection.
	 * @param amount - amount.
	 * @return long.
	 */
	public static long timeMeasureDelete(Collection<String> collection, int amount) {
		long firstTime = System.currentTimeMillis();
		TimeMeasure.delete(collection, amount);
		long lastTime = System.currentTimeMillis();
		return lastTime - firstTime;
	}

	/**
	 * method tests time.
	 * @param collection - collection.
	 * @param amountAdd - amount elements to add
	 * @param amountDelete - amount elements to delete
	 */
	public static void timeMeasureAddDelete(Collection<String> collection, int amountAdd, int amountDelete) {
		long resultAdd = 0;
		long resultDelete = 0;
		TimeMeasure.timeMeasureAdd(collection, amountAdd);
		for (int i = 0; i < 5; i++) {
			collection.clear();
			long tmAdd = TimeMeasure.timeMeasureAdd(collection, amountAdd);
			long tmDel = TimeMeasure.timeMeasureDelete(collection, amountDelete);
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