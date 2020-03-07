package ru.job4j.calculator;

import ru.job4j.calculator.controller.CalcController;
import ru.job4j.calculator.input.CalcInput;
import ru.job4j.calculator.input.ConsoleCalcInput;
import ru.job4j.calculator.view.CalcView;
import ru.job4j.calculator.view.ConsoleCalcView;

public class InteractCalcInit {

    public static void main(String[] args) {
        Calc calculator = CalcFabric.getInteractCalc();
        CalcView view = new ConsoleCalcView();
        CalcInput input = new ConsoleCalcInput();
        CalcController controller = new CalcController(view, input, calculator);
        controller.run();
    }
}
