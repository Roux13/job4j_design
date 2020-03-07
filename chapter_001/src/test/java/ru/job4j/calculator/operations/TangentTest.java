package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TangentTest {

    @Test
    public void calculateWhenArg0Then0() {
        CalcOperation tangent = new Tangent();
        double arg = 0;

        double expected = 0;

        double actual = tangent.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg60Then1Dot732() {
        CalcOperation tangent = new Tangent();
        double arg = 60;

        double expected = 1.732;

        double actual = tangent.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg45Then1() {
        CalcOperation tangent = new Tangent();
        double arg = 45;

        double expected = 1;

        double actual = tangent.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation tan1 = new Tangent();
        CalcOperation tan2 = new Tangent();

        boolean actual = tan1.equals(tan2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation tan1 = new Tangent();
        CalcOperation addition = new Addition();

        boolean actual = tan1.equals(addition);

        assertThat(actual, is(false));
    }

}