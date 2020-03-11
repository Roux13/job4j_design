package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Car;

public class ParkingManager {

    private final Parking parking;

    public ParkingManager(final Parking parking) {
        this.parking = parking;
    }

    public int[] checkPassengerSpaces(Car car) {
        return new int[0];
    }

    public int[] checkTruckSpaces(Car car) {
        return new int[0];
    }

    public ParkingAddress takePassengerSpace(Car car) throws NoSpaceException {
        return null;
    }

    public ParkingAddress takeTruckSpace(Car car) throws NoSpaceException {
        return null;
    }

    public void clearPassengerSpace(Car car) {

    }

    public void clearTruckSpace(Car car) {

    }
}
