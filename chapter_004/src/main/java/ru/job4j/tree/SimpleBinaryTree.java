package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * class SimpleBinaryTree.
 * @param <E> - value type.
 */
public class SimpleBinaryTree<E extends Comparable<E>> implements Iterable<E> {

    /** head of tree.*/
    private Node<E> head;

    /**
     * method add.
     * @param value - value to add.
     * @return boolean.
     */
    public boolean add(E value) {
        boolean result;
        if (head == null) {
            head = new Node<>(value);
            result = true;
        } else {
            result = addToNode(head, value);
        }
        return result;
    }

    /**
     * method add to node.
     * @param node - target node.
     * @param value - value to add.
     * @return boolean.
     */
    private boolean addToNode(Node<E> node, E value) {
        boolean result;
        if (node.value.compareTo(value) == 0) {
            result = false;
        } else if (node.value.compareTo(value) > 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(value);
                result = true;
            } else {
                result = addToNode(node.leftChild, value);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(value);
                result = true;
            } else {
                result = addToNode(node.rightChild, value);
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
        return new SimpleBinaryTreeIterator<E>(head);
    }

    /**
     * class tree iterator.
     * @param <E> - element.
     */
    class SimpleBinaryTreeIterator<E> implements Iterator<E> {
        /** data.*/
        private LinkedList<Node<E>> data = new LinkedList<>();
        /** iterator.*/
        private Iterator<Node<E>> iter;

        /**
         * constructor.
         * @param first - first node.
         */
        SimpleBinaryTreeIterator(Node<E> first) {
            findAll(first);
            iter = data.iterator();
        }

        /**
         * method hasNext.
         * @return boolean.
         */
        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        /**
         * method next.
         * @return value.
         */
        @Override
        public E next() {
            return iter.next().value;
        }

        /**
         * method findAll.
         * @param start - start node.
         */
        private void findAll(Node<E> start) {
            if (start != null) {
                findAll(start.leftChild);
                data.add(start);
                findAll(start.rightChild);
            }
        }
    }

    /**
     * class Node.
     * @param <E> - element.
     */
    class Node<E> {

        /** value.*/
        private E value;
        /** left child.*/
        private Node<E> leftChild;
        /** right child.*/
        private Node<E> rightChild;

        /**
         * constructor.
         * @param value - value.
         */
        Node(E value) {
            this.value = value;
        }
    }
}
