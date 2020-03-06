package ru.job4j.calculator;

import ru.job4j.calculator.Calc;
import ru.job4j.calculator.InteractCalc;
import ru.job4j.calculator.operations.*;

public class CalcBuilder {

    private static final CalcOperation[] INTERACT_OPERATION = {
        new Addition(),
                new Division(),
                new Multiplication(),
                new Subtraction()
    };

    private static final CalcOperation[] ENGINEER_OPERATION = {
            new Cosine()
    };

    public static Calc getInteractCalc() {
        return new InteractCalc(INTERACT_OPERATION);
    }

    public static Calc getEngineerCalc() {
        CalcOperation[] allOperations = new CalcOperation[INTERACT_OPERATION.length + ENGINEER_OPERATION.length];
        System.arraycopy(allOperations, 0, INTERACT_OPERATION, 0, ENGINEER_OPERATION.length);
        System.arraycopy(allOperations, ENGINEER_OPERATION.length, ENGINEER_OPERATION, 0, ENGINEER_OPERATION.length);
        return new InteractCalc(allOperations);
    }
}
