package ru.job4j.calculator;

import ru.job4j.calculator.controller.Controller;
import ru.job4j.calculator.controller.EngineerCalcController;
import ru.job4j.calculator.input.CalcInput;
import ru.job4j.calculator.input.ConsoleCalcInput;
import ru.job4j.calculator.view.CalcView;
import ru.job4j.calculator.view.ConsoleCalcView;

public class EngineerCalcInit {

    public static void main(String[] args) {
        Calc calculator = CalcFabric.getEngineerCalc();
        CalcView view = new ConsoleCalcView();
        CalcInput input = new ConsoleCalcInput();
        Controller controller = new EngineerCalcController(view, input, calculator);
        controller.run();
    }


}
