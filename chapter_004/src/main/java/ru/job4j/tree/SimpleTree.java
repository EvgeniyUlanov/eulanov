package ru.job4j.tree;

/**
 * interface SimpleTree.
 * @param <E> - element.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * method add.
     * @param parent - parent.
     * @param child - child.
     * @return boolean.
     */
    boolean add(E parent, E child);
}