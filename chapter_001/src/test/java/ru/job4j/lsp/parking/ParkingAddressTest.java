package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.interfaces.Address;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingAddressTest {

    @Test
    public void isPassengerParkingWhenTrue() {
        Address address = new ParkingAddress(true, null);
        boolean expected = true;

        boolean actual = address.isPassengerParking();

        assertThat(expected, is(actual));
    }

    @Test
    public void isPassengerParkingWhenFalse() {
        Address address = new ParkingAddress(false, null);
        boolean expected = false;

        boolean actual = address.isPassengerParking();

        assertThat(expected, is(actual));
    }

    @Test
    public void setPassengerParkingWhenTrue() {
        Address address = new ParkingAddress(false, null);
        boolean expected = true;

        address.setPassengerParking(true);
        boolean actual = address.isPassengerParking();

        assertThat(expected, is(actual));
    }

    @Test
    public void setPassengerParkingWhenFalse() {
        Address address = new ParkingAddress(true, null);
        boolean expected = false;

        address.setPassengerParking(false);
        boolean actual = address.isPassengerParking();

        assertThat(expected, is(actual));
    }

    @Test
    public void getAddressWhen0() {
        List<Integer> parkAddress = List.of(0);
        Address address = new ParkingAddress(true, parkAddress);
        List<Integer> expected = parkAddress;

        List<Integer> actual = address.getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void getAddressWhen99() {
        List<Integer> parkAddress = List.of(99);
        Address address = new ParkingAddress(true, parkAddress);
        List<Integer> expected = parkAddress;

        List<Integer> actual = address.getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void getAddressWhen1And2And3() {
        List<Integer> parkAddress = List.of(1, 2, 3);
        Address address = new ParkingAddress(true, parkAddress);
        List<Integer> expected = parkAddress;

        List<Integer> actual = address.getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void setAddressWhenAtFirst99After7() {
        List<Integer> firstParkAddress = List.of(99);
        List<Integer> secondParkAddress = List.of(7);
        Address address = new ParkingAddress(true, firstParkAddress);
        List<Integer> expected = secondParkAddress;

        address.setNumbers(secondParkAddress);
        List<Integer> actual = address.getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void setAddressWhenAtFirst1And2And3After7And8And9() {
        List<Integer> firstParkAddress = List.of(1, 2, 3);
        List<Integer> secondParkAddress = List.of(7, 8, 9);
        Address address = new ParkingAddress(true, firstParkAddress);
        List<Integer> expected = secondParkAddress;

        address.setNumbers(secondParkAddress);
        List<Integer> actual = address.getNumbers();

        assertEquals(expected, actual);
    }

    @Test
    public void setAddressWhenAtFirst1And2And3PassengerAddresAfter34TruckAddress() {
        List<Integer> firstParkAddress = List.of(1, 2, 3);
        List<Integer> secondParkAddress = List.of(7, 8, 9);
        Address address = new ParkingAddress(true, firstParkAddress);
        List<Integer> expectedAddress = secondParkAddress;
        boolean expectedIsPassengerAddress = false;

        address.setNumbers(secondParkAddress);
        address.setPassengerParking(false);
        List<Integer> actualAddress = address.getNumbers();
        boolean actualIsPassengerAddress = address.isPassengerParking();

        assertEquals(expectedAddress, actualAddress);
        assertThat(actualIsPassengerAddress, is(expectedIsPassengerAddress));

    }
}