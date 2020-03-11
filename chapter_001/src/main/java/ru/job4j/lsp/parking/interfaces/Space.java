package ru.job4j.lsp.parking.interfaces;

public interface Space {

    boolean isEmpty();

    void clear();

    Car getCar();

    void setCar(Car car);

}
