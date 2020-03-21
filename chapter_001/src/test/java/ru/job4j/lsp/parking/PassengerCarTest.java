package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassengerCarTest {

    @Test
    public void getSize() {
        Car passengerCar = new PassengerCar();
        int expected = 1;

        int actual = passengerCar.getSize();

        assertThat(actual, is(expected));
    }

    @Test
    public void setAddress() {
        List<Integer> parkAddress = List.of(7);
        Address address = new ParkingAddress(true, parkAddress);
        Car car = new PassengerCar();
        car.setAddress(address);
        Address expected = address;

        Address actual = car.getAddress();

        assertThat(actual, is(expected));
    }

}