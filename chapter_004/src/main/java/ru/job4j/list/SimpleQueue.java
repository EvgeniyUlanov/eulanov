package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleLinkedList.
 * @param <T> - type.
 */
public class SimpleQueue<T> implements Iterable<T> {
    /** first node.*/
    private Node<T> firstNode;
    /** last node.*/
    private Node<T> lastNode;

    /**
     * method add.
     * @param item - item.
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if (firstNode == null) {
            lastNode = newNode;
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    /**
     * method poll return last value and remove it from the list.
     * @return value.
     */
    public T poll() {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        T result = firstNode.item;
        if (firstNode.next == null) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.next;
        }
        return result;
    }

    /**
     * iterator.
     * @return iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = firstNode;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                T result = current.item;
                current = current.next;
                return result;
            }
        };
    }

    /**
     * class node.
     * @param <E> - type.
     */
    private class Node<E> {
        /** next node.*/
        private Node<E> next;
        /** item that keep value.*/
        private E item;

        /**
         * constructor.
         * @param item - new item.
         */
        Node(E item) {
            this.item = item;
        }
    }
}
