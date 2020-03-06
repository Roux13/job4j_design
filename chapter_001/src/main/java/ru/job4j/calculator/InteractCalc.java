package ru.job4j.calculator;

import ru.job4j.calculator.operations.*;

public class InteractCalc implements Calc {

    private CalcOperation[] operations = {
            new Addition(),
            new Division(),
            new Multiplication(),
            new Subtraction()
    };

    private final int clear;
    private final int repeat;
    private final int exit;

    private double lastValue;
    private int lastOperation;
    private boolean isClear;

    public InteractCalc() {
        this.isClear = true;
        this.clear = this.operations.length;
        this.repeat = this.operations.length + 1;
        this.exit = this.operations.length + 2;
    }

    public InteractCalc(CalcOperation[] operations) {
        this.operations = operations;
        this.isClear = true;
        this.clear = this.operations.length;
        this.repeat = this.operations.length + 1;
        this.exit = this.operations.length + 2;
    }

    @Override
    public void calculate(double first, double second, int operationNumber) {
        this.isClear = false;
        this.lastOperation = operationNumber;
        this.lastValue = this.operations[operationNumber].calculate(first, second);
    }

    @Override
    public void calculateAgain(double second) {
        calculate(this.lastValue, second, this.lastOperation);
    }

    @Override
    public void clear() {
        this.lastValue = 0;
        this.isClear = true;
    }

    @Override
    public int getLastOperation() {
        return lastOperation;
    }

    @Override
    public int getClear() {
        return clear;
    }

    @Override
    public int getRepeat() {
        return repeat;
    }

    @Override
    public int getExit() {
        return exit;
    }

    @Override
    public boolean isClear() {
        return this.isClear;
    }

    @Override
    public CalcOperation[] getOperations() {
        return this.operations;
    }

    @Override
    public double getLastValue() {
        return this.lastValue;
    }
}
