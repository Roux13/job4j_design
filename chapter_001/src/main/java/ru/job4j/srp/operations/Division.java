package ru.job4j.srp.operations;

public class Division implements CalcOperation {
    @Override
    public double calculate(double first, double second) {
        return first / second;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}