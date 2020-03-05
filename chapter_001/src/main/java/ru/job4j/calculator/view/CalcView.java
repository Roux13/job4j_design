package ru.job4j.calculator.view;

import ru.job4j.calculator.operations.CalcOperation;

public interface CalcView {

    void show(String message);

    void showMenu(CalcOperation[] operations, double lastValue);

    void showResult(double lastValue);

    void refresh();

    void installMenu(int clear, int repeat, int exit);
}
