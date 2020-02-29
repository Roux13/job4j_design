package ru.job4j.srp;

public class InteractCalc implements Calc {

    /**
     * Class Calculator for calculating arithmetic operations:
     * 1.add - addition.
     * 2.div - division.
     * 3.multiply - multiplication.
     * 4.subtrack - subtraction.
     *
     * @author Yuri Nehodov
     * @since 1.0
     * @version 1.0
     */

    private final String[] operations = {"Addition", "Division", "Multiplication", "Subtraction"};

    @Override
    public double add(double first, double second) {
        return first + second;
    }

    @Override
    public double div(double first, double second) {
        return first / second;
    }

    @Override
    public double multiply(double first, double second) {
        return first * second;
    }

    @Override
    public double subtrack(double first, double second) {
        return first - second;
    }

    public String[] getOperations() {
        return operations;
    }
}
