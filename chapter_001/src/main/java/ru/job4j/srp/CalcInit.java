package ru.job4j.srp;

public class CalcInit {

    public static void main(String[] args) {
        Calc calculator = new InteractCalc();
        CalcView view = new ConsoleCalcView();
        CalcInput input = new ConsoleCalcInput();
        CalcController controller = new CalcController(view, input, calculator);

    }
}
