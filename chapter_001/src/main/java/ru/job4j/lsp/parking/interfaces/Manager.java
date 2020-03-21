package ru.job4j.lsp.parking.interfaces;

import ru.job4j.lsp.parking.NoSpaceException;

import java.util.List;

public interface Manager {

    void putCarToParking(Car car);

    List<Integer> checkSpaces(Space[] spaces, int size);

    Address getSpace(Car car) throws NoSpaceException;

    void removeCar(Car car);

}
