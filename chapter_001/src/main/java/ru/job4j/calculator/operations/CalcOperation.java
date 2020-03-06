package ru.job4j.calculator.operations;

public interface CalcOperation {

    double calculate(double first, double second);

    String getSymbol();

    default String getName() {
        return getClass().getSimpleName();
    }

    default boolean isBinaryOperator() {
        return true;
    }
}
