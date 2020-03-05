package ru.job4j.calculator.view;

import ru.job4j.calculator.operations.CalcOperation;

public class ConsoleCalcView implements CalcView {

    private int clear;
    private int repeat;
    private int exit;

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void showMenu(final CalcOperation[] operations, final double lastValue) {
        this.refresh();
        this.showResult(lastValue);
        this.show(String.format("Select an operation(0 - %d):", exit));
        for (int i = 0; i < operations.length; i++) {
            this.show(String.format("%d. %s.", i, operations[i].getName()));
        }
        this.show(String.format("%d. Clear.", clear));
        this.show(String.format("%d. Repeat operation.", repeat));
        this.show(String.format("%d. Exit.", exit));
    }

    @Override
    public void showResult(final double lastValue) {
        this.show(String.format("Result: %f", lastValue));
        this.show("___________________________");
    }

    @Override
    public void refresh() {
        int countOfLines = 10;
        for (int i = 0; i < countOfLines; i++) {
            show("");
        }
    }

    @Override
    public void installMenu(final int clear, final int repeat, final int exit) {
        this.clear = clear;
        this.repeat = repeat;
        this.exit = exit;
    }
}
