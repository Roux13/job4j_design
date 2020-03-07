package ru.job4j.calculator.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CosineTest {

    @Test
    public void calculateWhenArg0Then1() {
        CalcOperation cosine = new Cosine();
        double arg = 0;

        double expected = 1;

        double actual = cosine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
        public void calculateWhenArg60Then05() {
            CalcOperation cosine = new Cosine();
            double arg = 60;

            double expected = 0.5;

            double actual = cosine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateWhenArg90Then0() {
        CalcOperation cosine = new Cosine();
        double arg = 90;

        double expected = 0;

        double actual = cosine.calculate(arg);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void equalsWhenBothCosineThenTrue() {
        CalcOperation cosine1 = new Cosine();
        CalcOperation cosine2 = new Cosine();

        boolean actual = cosine1.equals(cosine2);

        assertThat(actual, is(true));
    }

    @Test
    public void equalsWhenDifferentOperationThenFalse() {
        CalcOperation cosine1 = new Cosine();
        CalcOperation addition = new Addition();

        boolean actual = cosine1.equals(addition);

        assertThat(actual, is(false));
    }
}