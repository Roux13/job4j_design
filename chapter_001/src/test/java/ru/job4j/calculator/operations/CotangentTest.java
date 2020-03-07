package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CotangentTest {

    @Test
    public void calculateWhenArg90The0() {
        CalcOperation cot = new Cotangent();
        double arg = 90;

        double expected = 0;

        double actual = cot.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg60Then05773() {
        CalcOperation cot = new Cotangent();
        double arg = 60;

        double expected = 0.5773;

        double actual = cot.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg45Then1() {
        CalcOperation cot = new Cotangent();
        double arg = 45;

        double expected = 1;

        double actual = cot.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation cot1 = new Cotangent();
        CalcOperation cot2 = new Cotangent();

        boolean actual = cot1.equals(cot2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation cot1 = new Cotangent();
        CalcOperation addition = new Addition();

        boolean actual = cot1.equals(addition);

        assertThat(actual, is(false));
    }

}