package ru.job4j.calculator;

import ru.job4j.calculator.operations.*;

public class CalcFabric {

    private static final CalcOperation[] STANDARD_OPERATIONS = {
            new Addition(),
            new Division(),
            new Multiplication(),
            new Subtraction()
    };

    private static final CalcOperation[] ENGINEER_OPERATION = {
            new Square(),
            new SquareRoot(),
            new Sine(),
            new Cosine(),
            new Tangent(),
            new Cotangent()
    };

    public static Calc getInteractCalc() {
        return new InteractCalc(STANDARD_OPERATIONS);
    }

    public static Calc getEngineerCalc() {
        CalcOperation[] allOperations = new CalcOperation[STANDARD_OPERATIONS.length + ENGINEER_OPERATION.length];
        System.arraycopy(STANDARD_OPERATIONS, 0, allOperations, 0, STANDARD_OPERATIONS.length);
        System.arraycopy(ENGINEER_OPERATION, 0, allOperations, STANDARD_OPERATIONS.length, ENGINEER_OPERATION.length);
        return new InteractCalc(allOperations);
    }
}
