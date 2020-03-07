package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SineTest {

    @Test
    public void calculateWhenArg0Then0() {
        CalcOperation sine = new Sine();
        double arg = 0;

        double expected = 0;

        double actual = sine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg60Then0866() {
        CalcOperation sine = new Sine();
        double arg = 60;

        double expected = 0.866;

        double actual = sine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg90Then1() {
        CalcOperation sine = new Sine();
        double arg = 90;

        double expected = 1;

        double actual = sine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation sine1 = new Sine();
        CalcOperation sine2 = new Sine();

        boolean actual = sine1.equals(sine2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation sine1 = new Sine();
        CalcOperation addition = new Addition();

        boolean actual = sine1.equals(addition);

        assertThat(actual, is(false));
    }

}