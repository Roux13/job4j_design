package ru.job4j.tdd;

public interface Template {

    String generate(String template, String[] data) throws NoKeysInMapException, MoreKeysThanParametersException;

}
