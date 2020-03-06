package ru.job4j.calculator.operations;

public class Cosine implements CalcOperation {

    @Override
    public double calculate(double first, double second) {
        return Math.cos(first);
    }

    @Override
    public String getSymbol() {
        return "cos";
    }

    @Override
    public boolean isBinaryOperator() {
        return false;
    }
}
