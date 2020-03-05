package ru.job4j.calculator.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCalcInput implements CalcInput {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String receive() {
        String userMessage = null;
        try {
            userMessage = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userMessage;
    }

    @Override
    public double receiveNumber() {
        double result = 0.0;
        boolean invalid = true;
        while (invalid) {
            try {
                result = Double.parseDouble(this.receive());
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please, enter a number");
            }
        }
        return result;
    }

    @Override
    public double receiveNumberOfMenu(int max) {
        double result = 0.0;
        boolean invalid = true;
        while (invalid) {
            try {
                result = receiveNumber();
                if (Double.compare(result, 0) < 0 || Double.compare(result, max) > 0) {
                    throw new IllegalStateException();
                }
                invalid = false;
            } catch (IllegalStateException ise) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong input. Please, enter a number");
            }
        }
        return result;
    }
}
