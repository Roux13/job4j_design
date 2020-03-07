package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.operations.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalcFabricTest {

    @Test
    public void getInteractCalc() {
        CalcOperation[] operations = {
                new Addition(),
                new Division(),
                new Multiplication(),
                new Subtraction()
        };
        CalcOperation[] expected = new InteractCalc(operations).getOperations();

        CalcOperation[] actual = CalcFabric.getInteractCalc().getOperations();

        assertThat(actual, is(expected));
    }

    @Test
    public void getEngineerCalc() {
        CalcOperation[] operations = {
                new Addition(),
                new Division(),
                new Multiplication(),
                new Subtraction(),
                new Square(),
                new SquareRoot(),
                new Sine(),
                new Cosine(),
                new Tangent(),
                new Cotangent()
        };
        CalcOperation[] expected = new InteractCalc(operations).getOperations();

        CalcOperation[] actual = CalcFabric.getEngineerCalc().getOperations();

        assertThat(actual, is(expected));
    }

}