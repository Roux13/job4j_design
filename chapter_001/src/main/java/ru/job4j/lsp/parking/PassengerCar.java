package ru.job4j.lsp.parking;

public class PassengerCar implements Car {

    private final int passengerSize;

    private ParkingAddress parkingAddress;

    public PassengerCar() {
        this.passengerSize = 1;
    }

    @Override
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
