package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> head;

    /**
     * method add.
     * @param parent - parent.
     * @param child - child.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        if (head == null) {
            head = new Node<>(parent);
            head.addChild(child);
        } else {
            Node<E> resultParent = searchParent(head, parent);
            if (resultParent != null) {
                if (!resultParent.getValue().equals(child)) {
                    resultParent.addChild(child);
                } else {
                    result = false;
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        return result;
    }

    private Node<E> searchParent(Node<E> start, E parent) {
        Node<E> result = null;
        if (start.getValue().equals(parent)) {
            result = start;
        } else {
            for (Node<E> child : start.getChildren()) {
                result = searchParent(child, parent);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>(head);
    }

    class TreeIterator<E> implements Iterator<E> {

        ArrayList<Node<E>> data = new ArrayList<>();
        Iterator<Node<E>> iter;

        TreeIterator(Node<E> head) {
            findAll(head);
            iter = data.iterator();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public E next() {
            return iter.next().getValue();
        }

        private void findAll(Node<E> head) {
            if (head != null) {
                data.add(head);
                if (head.getChildren() != null) {
                    for (Node<E> child : head.getChildren()) {
                        findAll(child);
                    }
                }
            }
        }
    }

    class Node<E> {

        /** list to keep children.*/
        private List<Node<E>> children = new ArrayList<>();
        /** value.*/
        private E value;

        /**
         * constructor.
         * @param value - value.
         */
        Node(E value) {
            this.value = value;
        }

        /**
         * method addChild.
         * @param value - value.
         * @return boolean.
         */
        boolean addChild(E value) {
            children.add(new Node<E>(value));
            return true;
        }

        /**
         * method getValue.
         * @return value.
         */
        public E getValue() {
            return value;
        }

        /**
         * method getChildren.
         * @return list.
         */
        List<Node<E>> getChildren() {
            return children;
        }
    }
}
