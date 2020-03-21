package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TruckTest {


    @Test
    public void getSize() {
        int size = 3;
        Car truck = new Truck(size);
        int expected = size;

        int actual = truck.getSize();

        assertThat(actual, is(expected));
    }

    @Test
    public void setAddress() {
        int size = 3;
        List<Integer> parkAddress = List.of(7, 8, 9);
        Address address = new ParkingAddress(true, parkAddress);
        Car truck = new Truck(size);
        truck.setAddress(address);
        Address expected = address;

        Address actual = truck.getAddress();

        assertThat(actual, is(expected));
    }

}