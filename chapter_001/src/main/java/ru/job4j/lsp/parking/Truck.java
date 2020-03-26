package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;

import java.util.Objects;

public class Truck implements Car {

    private final int size;

    private Address address;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
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
        Truck truck = (Truck) o;
        return size == truck.size && Objects.equals(address, truck.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, address);
    }
}
