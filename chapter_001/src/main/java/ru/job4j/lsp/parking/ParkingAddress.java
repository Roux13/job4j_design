package ru.job4j.lsp.parking;

public class ParkingAddress {

    private boolean isPassengerParking;
    private int[] address;

    public ParkingAddress(boolean isPassengerParking, int[] address) {
        this.isPassengerParking = isPassengerParking;
        this.address = address;
    }

    public boolean isPassengerParking() {
        return isPassengerParking;
    }

    public void setPassengerParking(boolean passengerParking) {
        isPassengerParking = passengerParking;
    }

    public int[] getAddress() {
        return address;
    }

    public void setAddress(int[] address) {
        this.address = address;
    }
}
