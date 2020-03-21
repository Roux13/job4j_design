package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.interfaces.Car;
import ru.job4j.lsp.parking.interfaces.Space;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingSpaceTest {

    @Test
    public void isEmptyWhenNoCar() {
        Space parkingSpace = new ParkingSpace();
        boolean expected = true;

        boolean actual = parkingSpace.isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void isEmptyWhenHasPassengerCar() {
        Space parkingSpace = new ParkingSpace();
        Car car = new PassengerCar();
        parkingSpace.setCar(car);
        boolean expected = false;

        boolean actual = parkingSpace.isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void isEmptyWhenHasTruck() {
        Space parkingSpace = new ParkingSpace();
        Car car = new Truck(3);
        parkingSpace.setCar(car);
        boolean expected = false;

        boolean actual = parkingSpace.isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void clearWhenHasCar() {
        Space parkingSpace = new ParkingSpace();
        Car car = new Truck(3);
        parkingSpace.setCar(car);
        boolean expected = true;

        parkingSpace.clear();
        boolean actual = parkingSpace.isEmpty();

        assertThat(actual, is(expected));
    }
}