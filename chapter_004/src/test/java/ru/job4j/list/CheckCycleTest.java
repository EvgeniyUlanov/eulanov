package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test class CheckCycleTest.
 */
public class CheckCycleTest {
    /**
     * test method hasCycle 1-2-3-4-1.
     */
    @Test
    public void whenListHasCycleThanMethodReturnTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(first);

        assertThat(CheckCycle.hasCycle(first), is(true));
    }

    /**
     * test method hasCycle 1-2-3-4.
     */
    @Test
    public void whenListHasNotCycleThanMethodReturnFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        assertThat(CheckCycle.hasCycle(first), is(false));
    }

    /**
     * test method hasCycle 1-2-3-4-2.
     */
    @Test
    public void whenListHasCycleThanMethodReturnTrueFourthNodeNextSecond() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);

        assertThat(CheckCycle.hasCycle(first), is(true));
    }

    /**
     * test method hasCycle 1-2-3.
     */
    @Test
    public void whenListHasCycleThanMethodReturnTrueThirdNodeNextSecond() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        first.setNext(second);
        second.setNext(third);

        assertThat(CheckCycle.hasCycle(first), is(false));
    }
}
