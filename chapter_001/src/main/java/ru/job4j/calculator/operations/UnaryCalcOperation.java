package ru.job4j.calculator.operations;

public interface UnaryCalcOperation {

    double calculate(double argument);

    String getSymbol();

    default String getName() {
        return getClass().getSimpleName();
    }

}
