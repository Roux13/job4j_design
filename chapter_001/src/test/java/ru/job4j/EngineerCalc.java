package ru.job4j;

import ru.job4j.calculator.Calc;
import ru.job4j.calculator.operations.CalcOperation;

public class EngineerCalc implements Calc {



    @Override
    public void calculate(double first, double second, int operationNumber) {

    }

    @Override
    public void calculateAgain(double second) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int getLastOperation() {
        return 0;
    }

    @Override
    public int getClear() {
        return 0;
    }

    @Override
    public int getRepeat() {
        return 0;
    }

    @Override
    public int getExit() {
        return 0;
    }

    @Override
    public boolean isClear() {
        return false;
    }

    @Override
    public CalcOperation[] getOperations() {
        return new CalcOperation[0];
    }

    @Override
    public double getLastValue() {
        return 0;
    }
}
