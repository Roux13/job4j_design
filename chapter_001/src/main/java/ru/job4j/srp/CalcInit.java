package ru.job4j.srp;

import ru.job4j.srp.controller.CalcController;
import ru.job4j.srp.input.CalcInput;
import ru.job4j.srp.input.ConsoleCalcInput;
import ru.job4j.srp.view.CalcView;
import ru.job4j.srp.view.ConsoleCalcView;

public class CalcInit {

    public static void main(String[] args) {
        Calc calculator = new InteractCalc();
        CalcView view = new ConsoleCalcView();
        CalcInput input = new ConsoleCalcInput();
        CalcController controller = new CalcController(view, input, calculator);
        controller.run();
    }
}
