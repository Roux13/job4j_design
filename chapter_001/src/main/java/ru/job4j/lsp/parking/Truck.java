package ru.job4j.lsp.parking;

public class Truck implements Car {

    private final int truckSize;
    private final int passengerSize;

    private ParkingAddress parkingAddress;

    public Truck(int passengerSize) {
        this.truckSize = 1;
        this.passengerSize = passengerSize;
    }

    public int getTruckSize() {
        return truckSize;
    }

    public int getPassengerSize() {
        return passengerSize;
    }

    @Override
    public ParkingAddress getParkingAddress() {
        return parkingAddress;
    }

    @Override
    public void setParkingAddress(ParkingAddress parkingAddress) {
        this.parkingAddress = parkingAddress;
    }
}
