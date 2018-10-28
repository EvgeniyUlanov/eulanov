package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FunctionCalc {

    public static List<Double> diapason(int start, int finish,
                                        List<Integer> argsList,
                                        BiFunction<List<Integer>, Integer, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= finish; i++) {
            result.add(function.apply(argsList, i));
        }
        return result;
    }
}
