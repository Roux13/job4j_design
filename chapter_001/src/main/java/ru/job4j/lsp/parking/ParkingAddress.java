package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.interfaces.Address;

import java.util.List;
import java.util.Objects;

public class ParkingAddress implements Address {

    private boolean isPassengerParking;
    private List<Integer> numbers;

    public ParkingAddress(boolean isPassengerParking, List<Integer> numbers) {
        this.isPassengerParking = isPassengerParking;
        this.numbers = numbers;
    }

    @Override
    public boolean isPassengerParking() {
        return this.isPassengerParking;
    }

    @Override
    public void setPassengerParking(boolean passengerParking) {
        this.isPassengerParking = passengerParking;
    }

    @Override
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public void setNumbers(List<Integer> address) {
        this.numbers = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkingAddress that = (ParkingAddress) o;
        return isPassengerParking == that.isPassengerParking
                && Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPassengerParking, numbers);
    }
}
