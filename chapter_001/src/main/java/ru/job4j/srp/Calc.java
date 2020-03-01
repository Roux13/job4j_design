package ru.job4j.srp;


import ru.job4j.srp.operations.CalcOperation;

public interface Calc {

    abstract void calculate(double first, double second, int operationNumber);

    void calculateAgain(double second);

    void clear();

    int getLastOperation();

    int getClear();

    int getRepeat();

    int getExit();

    boolean isClear();

    abstract CalcOperation[] getOperations();

    double getLastValue();
}
