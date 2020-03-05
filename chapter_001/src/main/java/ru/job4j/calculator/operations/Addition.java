package ru.job4j.calculator.operations;

public class Addition implements CalcOperation {
    @Override
    public double calculate(double first, double second) {
        return first + second;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}