package ru.job4j.calculator.operations;

import java.util.Objects;

public class Sine implements CalcOperation {
    @Override
    public double calculate(double... args) {
        double radians = Math.toRadians(args[0]);
        return Math.sin(radians);
    }

    @Override
    public String getSymbol() {
        return "SIN()";
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
