package ru.job4j.lsp.parking;

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

    public ParkingAddress takePassengerSpaces(Car car) throws NoSpaceException {
        return null;
    }

    public ParkingAddress takeTruckSpaces(Car car) throws NoSpaceException {
        return null;
    }

    public void clearPassengerSpaces(Car car) {

    }

    public void clearTruckSpaces(Car car) {

    }
}
