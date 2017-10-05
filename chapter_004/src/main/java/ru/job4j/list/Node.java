package ru.job4j.list;

/**
 * class Node.
 */
public class Node<T> {
    /** value.*/
    private T value;
    /** next node.*/
    private Node<T> next;

    /**
     * constructor.
     * @param value - value.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * method setNext sets next Node.
     * @param next - next Node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * method getNext.
     * @return Node.
     */
    public Node<T> getNext() {
        return next;
    }
}