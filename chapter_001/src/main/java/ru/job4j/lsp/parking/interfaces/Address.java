package ru.job4j.lsp.parking.interfaces;

import java.util.List;

public interface Address {

    boolean isPassengerParking();

    void setPassengerParking(boolean passengerParking);

    List<Integer> getNumbers();

    void setNumbers(List<Integer> address);

}
