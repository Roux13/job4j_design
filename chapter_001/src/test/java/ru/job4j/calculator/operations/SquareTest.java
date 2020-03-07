package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void calculateWhenArg0Then0() {
        CalcOperation square = new Square();
        double arg = 0;

        double expected = 0;

        double actual = square.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg1Then1() {
        CalcOperation square = new Square();
        double arg = 1;

        double expected = 1;

        double actual = square.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg2Then4() {
        CalcOperation square = new Square();
        double arg = 2;

        double expected = 4;

        double actual = square.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation square1 = new Square();
        CalcOperation square2 = new Square();

        boolean actual = square1.equals(square2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation square = new Square();
        CalcOperation addition = new Addition();

        boolean actual = square.equals(addition);

        assertThat(actual, is(false));
    }

}