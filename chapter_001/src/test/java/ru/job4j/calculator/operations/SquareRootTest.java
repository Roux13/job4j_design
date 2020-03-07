package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareRootTest {

    @Test
    public void calculateWhenArg0Then0() {
        CalcOperation sqrt = new SquareRoot();
        double arg = 0;

        double expected = 0;

        double actual = sqrt.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg1Then1() {
        CalcOperation sqrt = new SquareRoot();
        double arg = 1;

        double expected = 1;

        double actual = sqrt.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg4Then2() {
        CalcOperation sqrt = new SquareRoot();
        double arg = 4;

        double expected = 2;

        double actual = sqrt.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation sqrt1 = new SquareRoot();
        CalcOperation sqrt2 = new SquareRoot();

        boolean actual = sqrt1.equals(sqrt2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation sqrt = new SquareRoot();
        CalcOperation addition = new Addition();

        boolean actual = sqrt.equals(addition);

        assertThat(actual, is(false));
    }

}