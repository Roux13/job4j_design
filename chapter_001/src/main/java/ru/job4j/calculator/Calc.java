package ru.job4j.calculator;


import ru.job4j.calculator.operations.CalcOperation;

public interface Calc {

    void calculate(double first, double second, int operationNumber);

    void calculateAgain(double second);

    void clear();

    int getLastOperation();

    int getClear();

    int getRepeat();

    int getExit();

    boolean isClear();

    CalcOperation[] getOperations();

    double getLastValue();
}
