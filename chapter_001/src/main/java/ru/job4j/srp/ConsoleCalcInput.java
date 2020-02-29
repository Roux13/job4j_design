package ru.job4j.srp;

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
    public int receiveNumber() {
        return Integer.parseInt(this.receive());
    }
}
