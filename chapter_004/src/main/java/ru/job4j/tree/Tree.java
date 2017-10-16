package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * class Tree.
 * @param <E> - element.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /** head of tree.*/
    private Node<E> head;

    /**
     * method add.
     * @param parent - parent.
     * @param child - child.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (head == null) {
            head = new Node<>(parent);
            head.addChild(child);
            result = true;
        } else {
            Node<E> resultParent = searchParent(head, parent);
            if (resultParent != null) {
                boolean inTree = false;
                for (E value : this) {
                    if (value.compareTo(child) == 0) {
                        inTree = true;
                    }
                }
                if (!inTree) {
                    resultParent.addChild(child);
                    result = true;
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        return result;
    }

    /**
     * method searchParent.
     * @param start - start node.
     * @param parent - value of parent.
     * @return node.
     */
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

    /**
     * class tree iterator.
     * @param <E> - element.
     */
    class TreeIterator<E> implements Iterator<E> {
        /** data.*/
        private ArrayList<Node<E>> data = new ArrayList<>();
        /** iterator.*/
        private Iterator<Node<E>> iter;

        /**
         * constructor.
         * @param first - first node.
         */
        TreeIterator(Node<E> first) {
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
            return iter.next().getValue();
        }

        /**
         * method findAll.
         * @param start - start node.
         */
        private void findAll(Node<E> start) {
            if (start != null) {
                data.add(start);
                if (start.getChildren() != null) {
                    for (Node<E> child : start.getChildren()) {
                        findAll(child);
                    }
                }
            }
        }
    }

    /**
     * class Node.
     * @param <E> - element.
     */
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
