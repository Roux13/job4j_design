package ru.job4j.lsp.parking;

public interface Car {

    int getPassengerSize();

    ParkingAddress getParkingAddress();

    void setParkingAddress(ParkingAddress parkingAddress);
}
