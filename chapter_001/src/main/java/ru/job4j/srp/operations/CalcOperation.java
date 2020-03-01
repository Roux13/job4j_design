package ru.job4j.srp.operations;

public interface CalcOperation {

    double calculate(double first, double second);

    String getSymbol();

    default String getName() {
        return getClass().getSimpleName();
    }
}
