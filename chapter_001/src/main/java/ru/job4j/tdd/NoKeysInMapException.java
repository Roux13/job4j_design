package ru.job4j.tdd;

public class NoKeysInMapException extends Exception {
    public NoKeysInMapException() {
        super("No keys in the map.");
    }
}
