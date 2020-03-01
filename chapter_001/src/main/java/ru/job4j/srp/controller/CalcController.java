package ru.job4j.srp.controller;

import ru.job4j.srp.Calc;
import ru.job4j.srp.input.CalcInput;
import ru.job4j.srp.view.CalcView;

public class CalcController {

    private final CalcView view;
    private final CalcInput input;
    private final Calc calculator;

    private boolean isRunning;

    public CalcController(final CalcView view, final CalcInput input, final Calc calculator) {
        this.view = view;
        this.input = input;
        this.calculator = calculator;
        this.isRunning = true;
        this.view.installMenu(calculator.getClear(), calculator.getRepeat(), calculator.getExit());
    }

    public void run() {
        while (this.isRunning) {
            view.showMenu(calculator.getOperations(), calculator.getLastValue());
            int select = (int) input.receiveNumberOfMenu(calculator.getExit());
            if (select == calculator.getExit()) {
                this.isRunning = false;
                view.refresh();
                view.show("Shutdown...");
                break;
            } else if (select == calculator.getClear()) {
                calculator.clear();
            } else if (select == calculator.getRepeat()) {
                this.repeatLastOperation();
            } else {
                if (calculator.isClear()) {
                    this.performOperation(select);
                } else {
                    this.performOperationWithLastValue(select);
                }
            }
        }
    }

    public void performOperation(final int operation) {
        this.askFirstArgument(operation);
        double first = input.receiveNumber();
        this.askSecondArgument(first, operation);
        double second = input.receiveNumber();
        this.calculator.calculate(first, second, operation);
    }

    public void performOperationWithLastValue(final int operation) {
        double first = calculator.getLastValue();
        this.askSecondArgument(first, operation);
        double second = input.receiveNumber();
        calculator.calculate(first, second, operation);
    }

    public void repeatLastOperation() {
        int lastOperation = calculator.getLastOperation();
        double lastValue = calculator.getLastValue();
        this.askSecondArgument(lastValue, lastOperation);
        double second = input.receiveNumber();
        calculator.calculate(lastValue, second, lastOperation);
    }

    private void askFirstArgument(final int operation) {
        view.refresh();
        view.showResult(calculator.getLastValue());
        view.show(String.format("%s:", calculator.getOperations()[operation].getName()));
        view.show("Input first argument:");
    }

    private void askSecondArgument(final double first, final int operation) {
        view.refresh();
        view.showResult(calculator.getLastValue());
        view.show(String.format("%s:", calculator.getOperations()[operation].getName()));
        view.show(String.format("%f %s ", first, calculator.getOperations()[operation].getSymbol()));
        view.show("Input second argument:");
    }

}
