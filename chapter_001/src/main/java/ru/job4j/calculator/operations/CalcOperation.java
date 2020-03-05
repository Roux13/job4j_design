package ru.job4j.calculator.operations;

public interface CalcOperation {

    TypesOfOperations TYPE = TypesOfOperations.BINARY;

    double calculate(double first, double second);

    String getSymbol();

    default String getName() {
        return getClass().getSimpleName();
    }
}
