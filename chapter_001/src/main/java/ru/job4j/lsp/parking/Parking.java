package ru.job4j.lsp.parking;

public class Parking {

    private final ParkingSpace[] passengerSpaces;
    private final ParkingSpace[] truckSpaces;

    public Parking(final int passengersCapacity, final int trucksCapacity) {
        this.passengerSpaces = new ParkingSpace[passengersCapacity];
        this.truckSpaces = new ParkingSpace[trucksCapacity];
    }

    public ParkingSpace[] getPassengerSpaces() {
        return passengerSpaces;
    }

    public ParkingSpace[] getTruckSpaces() {
        return truckSpaces;
    }
}
