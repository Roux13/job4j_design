package ru.job4j.srp;

public class CalcController {

    private final CalcView view;
    private final CalcInput calcInput;
    private final Calc calculator;

    public CalcController(final CalcView view, final CalcInput input, final Calc calculator) {
        this.view = view;
        this.calcInput = input;
        this.calculator = calculator;
    }

//    public void run() {
//        view.showMenu();
//    }

    public CalcView getView() {
        return view;
    }

    public CalcInput getCalcInput() {
        return calcInput;
    }

    public Calc getCalculator() {
        return calculator;
    }
}
