package ru.job4j.lsp.parking.interfaces;

public interface Address {

    public boolean isPassengerParking();

    public void setPassengerParking(boolean passengerParking);

    public int[] getAddress();

    public void setAddress(int[] address);

}
