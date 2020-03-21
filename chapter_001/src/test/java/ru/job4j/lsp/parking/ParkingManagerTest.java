package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.interfaces.Address;
import ru.job4j.lsp.parking.interfaces.Car;
import ru.job4j.lsp.parking.interfaces.IParking;
import ru.job4j.lsp.parking.interfaces.Space;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingManagerTest {

    @Test
    public void checkSpacesEmptyParkingThenZeroSpaceOnParking() {
        int passengerParkingSize = 3;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, passengerSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car car = new PassengerCar();
        List<Integer> expected = List.of(0);

        List<Integer> actual = parkingManager.checkSpaces(passengerSpaces, car.getSize());

        assertEquals(expected, actual);
    }

    @Test
    public void checkSpacesWhenFullParkingThenNoSpaceOnParking() {
        int passengerParkingSize = 3;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, passengerSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car car = new PassengerCar();
        List<Integer> expected = List.of();

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        passengerSpaces[2].setCar(new PassengerCar());
        List<Integer> actual = parkingManager.checkSpaces(passengerSpaces, car.getSize());

        assertEquals(expected, actual);
    }


    @Test
    public void checkSpacesWhenParkingHasTwoCarsThenSecondSpace() {
        int passengerParkingSize = 3;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        ParkingManager parkingManager = new ParkingManager(new Parking(passengerSpaces, passengerSpaces));
        Car car = new PassengerCar();
        List<Integer> expected = List.of(2);

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        List<Integer> actual = parkingManager.checkSpaces(passengerSpaces, car.getSize());

        assertEquals(expected, actual);
    }

    @Test
    public void getSpaceWhenPassengerCarAndPassengerSpacesEmptyThenAddressPassenger0() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car passengerCar = new PassengerCar();
        Address expected = new ParkingAddress(true, List.of(0));

        Address actual = null;
        try {
            actual = parkingManager.getSpace(passengerCar);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getSpaceWhenPassengerCarAndPassengerSpacesHasTwoCarsThenAddressPassenger2() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car passengerCar = new PassengerCar();
        Address expected = new ParkingAddress(true, List.of(2));

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        Address actual = null;
        try {
            actual = parkingManager.getSpace(passengerCar);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test(expected = NoSpaceException.class)
    public void getSpaceWhenPassengerCarAndPassengerSpacesFullThenNoSpaceException() throws NoSpaceException {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car passengerCar = new PassengerCar();

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        passengerSpaces[2].setCar(new PassengerCar());
        parkingManager.getSpace(passengerCar);
    }

    @Test
    public void getSpaceWhenTruckAndTruckSpacesEmptyThenAddressTruck0() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car truck = new Truck(3);
        Address expected = new ParkingAddress(false, List.of(0));

        Address actual = null;
        try {
            actual = parkingManager.getSpace(truck);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void getSpaceWhenTruckAndTruckSpacesFullButEmptyPassengerThenAddressPassenger0And1And2() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car truck = new Truck(3);
        Address expected = new ParkingAddress(true, List.of(0, 1, 2));

        truckSpaces[0].setCar(new Truck(3));
        Address actual = null;
        try {
            actual = parkingManager.getSpace(truck);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test(expected = NoSpaceException.class)
    public void getSpaceWhenTruckAndAllSpacesFullThenNoSpaceException() throws NoSpaceException {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car truck = new Truck(3);

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        passengerSpaces[2].setCar(new PassengerCar());
        truckSpaces[0].setCar(new Truck(3));
        parkingManager.getSpace(truck);
    }

    @Test
    public void getSpaceWhenTruckAndTruckSpacesFullAndPassengerHasTwoCarsThenAddressPassenger2And3And4() {
        int passengerParkingSize = 6;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car truck = new Truck(3);
        Address expected = new ParkingAddress(true, List.of(2, 3, 4));

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        truckSpaces[0].setCar(new Truck(3));
        Address actual = null;
        try {
            actual = parkingManager.getSpace(truck);
        } catch (NoSpaceException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void putCarToParkingWhenPassengerCarAndEmptyParkingThenCarOnZeroPassengerSpace() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car expected = new PassengerCar();

        parkingManager.putCarToParking(expected);
        Car actual = passengerSpaces[0].getCar();

        assertThat(actual, is(expected));
    }

    @Test
    public void putCarToParkingWhenPassengerCarAndParkingHasTwoCarsThenCarOnFirstPassengerSpace() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car expected = new PassengerCar();

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[2].setCar(new PassengerCar());
        parkingManager.putCarToParking(expected);
        Car actual = passengerSpaces[1].getCar();

        assertThat(actual, is(expected));
    }

    @Test
    public void putCarToParkingWhenPassengerCarAndParkingFullThenMessageAboutIt() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        String expected = "Sorry... The parking is full." + System.lineSeparator();

        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(new PassengerCar());
        passengerSpaces[2].setCar(new PassengerCar());
        parkingManager.putCarToParking(new PassengerCar());
        String actual = baos.toString();

        assertThat(actual, is(expected));
        System.setOut(stdOut);
    }

    @Test
    public void putCarToParkingWhenTruckCarAndTruckParkingEmptyThenTruckOnZeroTruckSpace() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car expected = new Truck(3);

        parkingManager.putCarToParking(expected);
        Car actual = truckSpaces[0].getCar();

        assertThat(actual, is(expected));

    }

    @Test
    public void putCarToParkingWhenTruckCarAndTruckParkingFullThenTruckOnZeroAndFirstAndSecondPassengerSpaces() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car expected = new Truck(3);

        truckSpaces[0].setCar(new Truck(3));
        parkingManager.putCarToParking(expected);
        Car actual1 = passengerSpaces[0].getCar();
        Car actual2 = passengerSpaces[1].getCar();
        Car actual3 = passengerSpaces[2].getCar();

        assertThat(actual1, is(expected));
        assertThat(actual2, is(expected));
        assertThat(actual3, is(expected));

    }

    @Test
    public void clearSpaceWhenPassengerCar() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car car = new PassengerCar();
        Address address = new ParkingAddress(true, List.of(1));
        car.setAddress(address);

        passengerSpaces[0].setCar(new PassengerCar());
        passengerSpaces[1].setCar(car);
        passengerSpaces[2].setCar(new PassengerCar());
        assertThat(passengerSpaces[1].isEmpty(), is(false));

        parkingManager.removeCar(car);

        assertThat(passengerSpaces[1].isEmpty(), is(true));
    }

    @Test
    public void clearSpaceWhenTruck() {
        int passengerParkingSize = 3;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car car = new Truck(3);
        Address address = new ParkingAddress(false, List.of(0));
        car.setAddress(address);

        truckSpaces[0].setCar(car);
        assertThat(truckSpaces[0].isEmpty(), is(false));

        parkingManager.removeCar(car);

        assertThat(truckSpaces[0].isEmpty(), is(true));
    }

    @Test
    public void clearSpaceWhenTruckOnPassengerSpaces() {
        int passengerParkingSize = 6;
        int truckParkingSize = 1;
        Space[] passengerSpaces = new Space[passengerParkingSize];
        Space[] truckSpaces = new Space[truckParkingSize];
        passengerSpaces = Arrays.stream(passengerSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        truckSpaces = Arrays.stream(truckSpaces).map(space -> space = new ParkingSpace()).toArray(Space[]::new);
        IParking parking = new Parking(passengerSpaces, truckSpaces);
        ParkingManager parkingManager = new ParkingManager(parking);
        Car car = new Truck(3);
        Address address = new ParkingAddress(true, List.of(2, 3, 4));
        car.setAddress(address);

        passengerSpaces[2].setCar(car);
        passengerSpaces[3].setCar(car);
        passengerSpaces[4].setCar(car);
        assertThat(passengerSpaces[2].isEmpty(), is(false));
        assertThat(passengerSpaces[3].isEmpty(), is(false));
        assertThat(passengerSpaces[4].isEmpty(), is(false));

        parkingManager.removeCar(car);

        assertThat(passengerSpaces[2].isEmpty(), is(true));
        assertThat(passengerSpaces[3].isEmpty(), is(true));
        assertThat(passengerSpaces[4].isEmpty(), is(true));
    }
}