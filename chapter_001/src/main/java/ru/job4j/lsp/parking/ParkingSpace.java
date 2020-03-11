package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Car;

public class ParkingSpace {

    private Car car;

    boolean isEmpty() {
        return true;
    }

    void clear() {

    }

    Car getCar() {
        return this.car;
    }

    void setCar(Car car) {
        this.car = car;
    }

}
