package ru.job4j.tdd;

public class MoreKeysThanParametersException extends Exception {
    public MoreKeysThanParametersException() {
        super("More keys than parameters");
    }
}
