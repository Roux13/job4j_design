package ru.job4j.lsp.parking;

public class NoSpaceException extends Exception {
    public NoSpaceException() {
        super("No space in the parking");
    }
}
