package ru.job4j.calculator.operations;

import java.util.Objects;

public class Square implements CalcOperation {

    @Override
    public double calculate(double... args) {
        return Math.pow(args[0], 2);
    }

    @Override
    public String getSymbol() {
        return "X^2";
    }

    @Override
    public boolean isUnaryOperator() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass());
    }
}
