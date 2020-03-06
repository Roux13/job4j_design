package ru.job4j.calculator.controller;

public interface Controller {
    void run();

    void performOperation(int operation);

    void performOperationWithLastValue(int operation);

    void repeatLastOperation();

    void askFirstArgument(int operation);

    void askSecondArgument(double first, int operation);
}
