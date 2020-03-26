package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.IParking;
import ru.job4j.lsp.parking.interfaces.Space;

import java.util.Arrays;

public class Parking implements IParking {

    private final Space[] passengerSpaces;
    private final Space[] truckSpaces;

    public Parking(final Space[] passengerSpaces, final Space[] truckSpaces) {
        this.passengerSpaces = passengerSpaces;
        this.truckSpaces = truckSpaces;
    }

    @Override
    public Space[] getPassengerSpaces() {
        return passengerSpaces;
    }

    @Override
    public Space[] getTruckSpaces() {
        return truckSpaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parking parking = (Parking) o;
        return Arrays.equals(passengerSpaces, parking.passengerSpaces)
                && Arrays.equals(truckSpaces, parking.truckSpaces);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(passengerSpaces);
        result = 31 * result + Arrays.hashCode(truckSpaces);
        return result;
    }
}
