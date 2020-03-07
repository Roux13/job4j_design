package ru.job4j.calculator.controller;

import ru.job4j.calculator.Calc;
import ru.job4j.calculator.input.CalcInput;
import ru.job4j.calculator.view.CalcView;

public class EngineerCalcController implements Controller {

    private CalcController controller;

    private boolean isRunning;

    private final double stub = 1;

    public EngineerCalcController(final CalcView view, final CalcInput input, final Calc calculator) {
        this.controller = new CalcController(view, input, calculator);
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            controller.getView().showMenu(controller.getCalculator().getOperations(), controller.getCalculator().getLastValue());
            int select = (int) controller.getInput().receiveNumberOfMenu(controller.getCalculator().getExit());
            if (select == controller.getCalculator().getExit()) {
                isRunning = false;
                controller.getView().refresh();
                controller.getView().show("Shutdown...");
                break;
            } else if (select == controller.getCalculator().getClear()) {
                controller.getCalculator().clear();
            } else if (select == controller.getCalculator().getRepeat()) {
                this.repeatLastOperation();
            } else {
                if (controller.getCalculator().isClear()) {
                    this.performOperation(select);
                } else {
                    this.performOperationWithLastValue(select);
                }
            }
        }
    }


    @Override
    public void performOperation(int operation) {
        if (controller.getCalculator().getOperations()[operation].isUnaryOperator()) {
            this.performUnaryOperation(operation);
        } else {
            controller.performOperation(operation);
        }
    }

    public void performUnaryOperation(int operation) {
        this.askFirstArgument(operation);
        double argument = controller.getInput().receiveNumber();
        controller.getCalculator().calculate(argument, stub, operation);
    }

    @Override
    public void performOperationWithLastValue(int operation) {
        this.askFirstArgument(operation);
        controller.getCalculator().calculate(controller.getCalculator().getLastValue(), stub, operation);
    }

    @Override
    public void repeatLastOperation() {
        this.performOperationWithLastValue(controller.getCalculator().getLastOperation());
    }

    @Override
    public void askFirstArgument(int operation) {
        controller.askFirstArgument(operation);
    }

    @Override
    public void askSecondArgument(double first, int operation) {
        controller.askSecondArgument(first, operation);
    }
}
