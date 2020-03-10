package ru.job4j.isp;

public class ConsoleOutput implements Output {

    @Override
    public void display(String text) {
        System.out.println(text);
    }

}
