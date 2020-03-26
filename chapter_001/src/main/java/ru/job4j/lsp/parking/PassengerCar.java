package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;

import java.util.Objects;

public class PassengerCar implements Car {

    private final int size;

    private Address address;

    public PassengerCar() {
        this.size = 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return size == that.size && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, address);
    }
}
