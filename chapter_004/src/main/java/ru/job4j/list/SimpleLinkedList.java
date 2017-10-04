package ru.job4j.list;

import java.util.Iterator;

/**
 * SimpleLinkedList.
 * @param <T> - type.
 */
public class SimpleLinkedList<T> implements Iterable<T> {
    /** size of list.*/
    private int size;
    /** first node.*/
    private Node<T> firstNode;
    /** last node.*/
    private Node<T> lastNode;

    /**
     * metod add.
     * @param item - item.
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (firstNode == null) {
            lastNode = newNode;
            firstNode = lastNode;
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;
        }
        size++;
    }

    /**
     * metod get.
     * @param index - index.
     * @return value.
     */
    public T get(int index) {
        if (index < size) {
            Node<T> current = firstNode;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return current.item;
                }
                current = current.next;
            }
        }
        return null;
    }

    /**
     * iterator.
     * @return iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node current = firstNode;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T result = (T) current.item;
                current = current.next;
                return result;
            }
        };
    }

    /**
     * class node.
     * @param <T> - type.
     */
    private class Node<T> {
        /** next node.*/
        private Node<T> next;
        /** previous node.*/
        private Node<T> previous;
        /** item that keep value.*/
        private T item;

        /**
         * constructor.
         * @param item - new item.
         */
        Node(T item) {
            this.item = item;
        }
    }
}
