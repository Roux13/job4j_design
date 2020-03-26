package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Manager {

    private final IParking parking;

    public ParkingManager(final IParking parking) {
        this.parking = parking;
    }

    @Override
    public void putCarToParking(Car car) {
        Address address;
        try {
            address = this.getSpace(car);
            Space[] currentParking = address.isPassengerParking() ? parking.getPassengerSpaces() : parking.getTruckSpaces();
            for (Integer number : address.getNumbers()) {
                currentParking[number].setCar(car);
                car.setAddress(address);
            }
        } catch (NoSpaceException e) {
            System.out.println("Sorry... The parking is full.");
        }
    }

    @Override
    public Address getSpace(Car car) throws NoSpaceException {
        Address result;
        if (car.getSize() > 1) {
            result = getTruckSpace(car);
        } else {
            result = getPassengerSpace(car);
        }
        if (result == null) {
            throw new NoSpaceException();
        }
        return result;
    }


    private Address getTruckSpace(Car car) {
        Address result;
        List<Integer> spaces = checkSpaces(parking.getTruckSpaces(), 1);
        if (!spaces.isEmpty()) {
            result = new ParkingAddress(false, spaces);
        } else {
            result = getPassengerSpace(car);
        }
        return result;
    }

    private Address getPassengerSpace(Car car) {
        Address result = null;
        List<Integer> spaces = checkSpaces(parking.getPassengerSpaces(), car.getSize());
        if (!spaces.isEmpty()) {
            result = new ParkingAddress(true, spaces);
        }
        return result;
    }

    @Override
    public List<Integer> checkSpaces(Space[] spaces, int size) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < spaces.length; index++) {
            for (int cell = index; cell < spaces.length && cell < index + size; cell++) {
                if (spaces[index].isEmpty()) {
                    result.add(cell);
                }
            }
            if (result.size() != size) {
                result.clear();
            } else {
                break;
            }
        }
        return result;
    }


    @Override
    public void removeCar(Car car) {
        if (car.getAddress().isPassengerParking()) {
            clearSpace(parking.getPassengerSpaces(), car.getAddress().getNumbers());
        } else {
            clearSpace(parking.getTruckSpaces(), car.getAddress().getNumbers());
        }
    }

    private void clearSpace(Space[] spaces, List<Integer> numbers) {
        numbers.forEach(number -> spaces[number].clear());
    }

}
