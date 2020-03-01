package ru.job4j.srp.input;

public interface CalcInput {

    String receive();

    double receiveNumber();

    double receiveNumberOfMenu(int max);
}
