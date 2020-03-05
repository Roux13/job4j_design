package ru.job4j.calculator.input;

public interface CalcInput {

    String receive();

    double receiveNumber();

    double receiveNumberOfMenu(int max);
}
