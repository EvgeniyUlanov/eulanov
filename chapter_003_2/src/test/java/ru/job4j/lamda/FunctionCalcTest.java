package ru.job4j.lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionCalcTest {
    @Test
    public void testLinerFunction() {
        List result = FunctionCalc.diapason(0, 2,
                Arrays.asList(2, 3),
                (list, x) -> {
                    Objects.requireNonNull(list.get(0));
                    Objects.requireNonNull(list.get(1));
                    return (double) (list.get(0) * x + list.get(1));
                }
        );

        List<Double> expected = Arrays.asList(3.0, 5.0, 7.0);
        assertThat(result, is(expected));
    }

    @Test
    public void testSquareFunction() {
        List result = FunctionCalc.diapason(0, 2,
                Arrays.asList(2, 3, 1),
                (list, x) -> {
                    Objects.requireNonNull(list.get(0));
                    Objects.requireNonNull(list.get(1));
                    Objects.requireNonNull(list.get(2));
                    return (double) (list.get(0) * x * x + list.get(1) * x + list.get(2));
                }
        );

        List<Double> expected = Arrays.asList(1.0, 6.0, 15.0);
        assertThat(result, is(expected));
    }

    @Test
    public void testLogarithmFunction() {
        List result = FunctionCalc.diapason(1, 4,
                Collections.singletonList(2),
                (list, x) -> {
                    Objects.requireNonNull(list.get(0));
                    return Math.log(x) / Math.log(list.get(0));
                }
        );

        List<Double> expected = Arrays.asList(0.0, 1.0, 1.5849625007211563, 2.0);
        assertThat(result, is(expected));
    }
}
