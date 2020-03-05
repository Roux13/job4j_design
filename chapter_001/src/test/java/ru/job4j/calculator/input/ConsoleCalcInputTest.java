package ru.job4j.calculator.input;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleCalcInputTest {

    @Test
    public void receiveWhenInputIsStringThenString() {
        String userMessage = "String";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        String expected = userMessage;

        String actual = consoleCalcInput.receive();

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void receiveWhenInputIsEmptyThenNull() {
        String userMessage = "";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        String expected = null;

        String actual = consoleCalcInput.receive();

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void receiveNumberWhenInputIsNumberStringThenDoubleNumber() {
        String userMessage = "1.0";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        double expected = Double.parseDouble(userMessage);

        double actual = consoleCalcInput.receiveNumber();

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void receiveNumberWhenFirstInputIsNotNumberStringAndSecondInputValidThenDoubleNumber() {
        String userMessage1 = String.format("String %n2.0");
        String userMessage2 = "2.0";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage1.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        double expected = Double.parseDouble(userMessage2);

        double actual = consoleCalcInput.receiveNumber();

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void receiveNumberOfMenuWhenInputIsSmallerThanZeroThenDoubleNumber() {
        String userMessage1 = String.format("-1%n2");
        String userMessage2 = "2.0";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage1.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        double expected = Double.parseDouble(userMessage2);

        double actual = consoleCalcInput.receiveNumberOfMenu(2);

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void receiveNumberOfMenuWhenInputIsBiggerThanMax() {
        String userMessage1 = String.format("3%n2");
        String userMessage2 = "2.0";
        InputStream stdIn = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream(userMessage1.getBytes());
        System.setIn(testInput);
        ConsoleCalcInput consoleCalcInput = new ConsoleCalcInput();
        double expected = Double.parseDouble(userMessage2);

        double actual = consoleCalcInput.receiveNumberOfMenu(2);

        assertThat(actual, is(expected));
        System.setIn(stdIn);
    }
}