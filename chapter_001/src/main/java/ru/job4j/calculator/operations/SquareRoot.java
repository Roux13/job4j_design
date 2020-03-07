package ru.job4j.calculator.operations;

import java.util.Objects;

public class SquareRoot implements CalcOperation {

    @Override
    public double calculate(double... args) {
        return Math.sqrt(args[0]);
    }

    @Override
    public String getSymbol() {
        return String.valueOf('\u221A');
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
