package ru.job4j.lsp.parking.interfaces;

import ru.job4j.lsp.parking.ParkingAddress;

public interface Car {

    int getSize();

    Address getAddress();

    void setAddress(Address address);
}
