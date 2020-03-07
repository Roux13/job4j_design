package ru.job4j.calculator.operations;

import java.util.Objects;

public class Subtraction implements CalcOperation {
    @Override
    public double calculate(double... args) {
        return args[0] - args[1];
    }

    @Override
    public String getSymbol() {
        return "-";
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
