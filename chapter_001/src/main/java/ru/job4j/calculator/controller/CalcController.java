package ru.job4j.calculator.controller;

import ru.job4j.calculator.Calc;
import ru.job4j.calculator.input.CalcInput;
import ru.job4j.calculator.view.CalcView;

public class CalcController implements Controller {

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

    @Override
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

    @Override
    public void performOperation(final int operation) {
        this.askFirstArgument(operation);
        double first = input.receiveNumber();
        this.askSecondArgument(first, operation);
        double second = input.receiveNumber();
        this.calculator.calculate(first, second, operation);
    }

    @Override
    public void performOperationWithLastValue(final int operation) {
        double first = calculator.getLastValue();
        this.askSecondArgument(first, operation);
        double second = input.receiveNumber();
        calculator.calculate(first, second, operation);
    }

    @Override
    public void repeatLastOperation() {
        int lastOperation = calculator.getLastOperation();
        double lastValue = calculator.getLastValue();
        this.askSecondArgument(lastValue, lastOperation);
        double second = input.receiveNumber();
        calculator.calculate(lastValue, second, lastOperation);
    }

    @Override
    public void askFirstArgument(final int operation) {
        view.refresh();
        view.showResult(calculator.getLastValue());
        view.show(String.format("%s:", calculator.getOperations()[operation].getName()));
        view.show("Output first argument:");
    }

    @Override
    public void askSecondArgument(final double first, final int operation) {
        view.refresh();
        view.showResult(calculator.getLastValue());
        view.show(String.format("%s:", calculator.getOperations()[operation].getName()));
        view.show(String.format("%f %s ", first, calculator.getOperations()[operation].getSymbol()));
        view.show("Output second argument:");
    }


    public CalcView getView() {
        return view;
    }

    public CalcInput getInput() {
        return input;
    }

    public Calc getCalculator() {
        return calculator;
    }

}
