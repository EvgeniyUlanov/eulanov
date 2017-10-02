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
            lastNode.setNext(newNode);
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
                    return current.getItem();
                }
                current = current.getNext();
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
                T result = (T) current.getItem();
                current = current.getNext();
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
        /** item that keep value.*/
        private T item;

        /**
         * constructor.
         * @param item - new item.
         */
        Node(T item) {
            this.item = item;
            this.next = null;
        }

        /**
         * metod get next node.
         * @return next node.
         */
        Node<T> getNext() {
            return next;
        }

        /**
         * metod set next node.
         * @param node - node.
         */
        void setNext(Node<T> node) {
            this.next = node;
        }

        /**
         * metod getItem.
         * @return item.
         */
        T getItem() {
            return item;
        }
    }
}
