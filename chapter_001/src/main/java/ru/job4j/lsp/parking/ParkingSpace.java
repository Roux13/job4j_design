package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Car;
import ru.job4j.lsp.parking.interfaces.Space;

import java.util.Objects;

public class ParkingSpace implements Space {

    private Car car;

    @Override
    public boolean isEmpty() {
        return car == null;
    }

    @Override
    public void clear() {
        this.car = null;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkingSpace that = (ParkingSpace) o;
        return Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
