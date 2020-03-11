package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Car;

public class Truck {

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

//    @Override
//    public int getSize() {
//        return passengerSize;
//    }

//    @Override
//    public ParkingAddress getParkingAddress() {
//        return parkingAddress;
//    }
//
//    @Override
//    public void setParkingAddress(ParkingAddress parkingAddress) {
//        this.parkingAddress = parkingAddress;
//    }
}
