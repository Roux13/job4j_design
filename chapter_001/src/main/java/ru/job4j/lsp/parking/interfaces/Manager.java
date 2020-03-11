package ru.job4j.lsp.parking.interfaces;

import ru.job4j.lsp.parking.NoSpaceException;
import ru.job4j.lsp.parking.ParkingAddress;

public interface Manager {

    public ParkingAddress takePassengerSpace(Car car) throws NoSpaceException;

    public ParkingAddress takeTruckSpace(Car car) throws NoSpaceException;

    public void clearPassengerSpace(Car car);

    public void clearTruckSpace(Car car);

}
