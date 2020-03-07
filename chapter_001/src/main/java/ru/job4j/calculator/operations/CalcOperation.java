package ru.job4j.calculator.operations;

import java.util.Objects;

public interface CalcOperation {

    double calculate(double... args);

    String getSymbol();

    default String getName() {
        return getClass().getSimpleName();
    }

    default boolean isUnaryOperator() {
        return false;
    }

}
