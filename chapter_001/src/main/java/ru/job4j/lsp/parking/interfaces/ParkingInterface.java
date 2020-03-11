package ru.job4j.lsp.parking.interfaces;

import ru.job4j.lsp.parking.ParkingSpace;

public interface ParkingInterface {

    Space[] getPassengerSpaces();

    Space[] getTruckSpaces();

}
