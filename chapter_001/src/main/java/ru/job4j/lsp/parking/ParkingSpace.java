package ru.job4j.lsp.parking;

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
