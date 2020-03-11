package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;

public class PassengerCar implements Car {

    private final int passengerSize;

    private Address address;

    public PassengerCar() {
        this.passengerSize = 1;
    }

    @Override
    public int getSize() {
        return passengerSize;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }
}
