package ru.job4j.list;

/**
 * class check cycle.
 */
class CheckCycle {
    /**
     * method checks cycle.
     * @param first - start node.
     * @return boolean.
     */
    public static boolean hasCycle(Node first) {
        boolean result = false;
        if (first != null) {
            Node current = first;
            Node second = first;
            while (current.getNext() != null && !result && second.getNext().getNext() != null) {
                current = current.getNext();
                second = second.getNext().getNext();
                result = current == second;
            }
        }
        return result;
    }
}
