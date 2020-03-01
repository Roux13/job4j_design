package ru.job4j.srp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InteractCalcTest {

    @Test
    public void calculateWhenOpAddition() {
        Calc calc = new InteractCalc();
        double first = 0;
        double second = 1;
        int operationNumber = 0;
        double expected = 1;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpDivision() {
        Calc calc = new InteractCalc();
        double first = 4;
        double second = 2;
        int operationNumber = 1;
        double expected = 2;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpMultiplication() {
        Calc calc = new InteractCalc();
        double first = 1;
        double second = 2;
        int operationNumber = 2;
        double expected = 2;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void clculateWhenOpSubtraction() {
        Calc calc = new InteractCalc();
        double first = 1;
        double second = 2;
        int operationNumber = 3;
        double expected = -1;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpDivisionByZeroThenPositiveInfinity() {
        Calc calc = new InteractCalc();
        double first = 4;
        double second = 0;
        int operationNumber = 1;
        double expected = Double.POSITIVE_INFINITY;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpMultiplicationWithDecimals() {
        Calc calc = new InteractCalc();
        double first = 1.1;
        double second = 2.0;
        int operationNumber = 2;
        double expected = 2.2;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpDivisionWithDecimals() {
        Calc calc = new InteractCalc();
        double first = 1;
        double second = 4;
        int operationNumber = 1;
        double expected = 0.25;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateWhenOpDivisionWithDecimalsAndResultInPeriod() {
        Calc calc = new InteractCalc();
        double first = 1;
        double second = 3;
        int operationNumber = 1;
        double expected = 0.3333333333333333;

        calc.calculate(first, second, operationNumber);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void calculateAgainWhenOpAddition() {
        Calc calc = new InteractCalc();
        double first = 0;
        double second = 1;
        int operationNumber = 0;
        double expected = 2;

        calc.calculate(first, second, operationNumber);
        calc.calculateAgain(second);
        double actual = calc.getLastValue();

        assertThat(actual, is(expected));
    }

    @Test
    public void clear() {
        Calc calc = new InteractCalc();
        double first = 0;
        double second = 1;
        int operationNumber = 0;

        calc.calculate(first, second, operationNumber);
        calc.clear();

        assertThat(calc.getLastValue(), is(0.0));
        assertThat(calc.isClear(), is(true));
    }
}