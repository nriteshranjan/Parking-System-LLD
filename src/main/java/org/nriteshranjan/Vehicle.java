package org.nriteshranjan;

public class Vehicle {
    private String name;
    private String registrationId;
    private String owner;
    private int wheelCount;
    protected ParkingLotImpl parkingLot;

    public Vehicle(String name, String registrationId, String owner) {
        this.name = name;
        this.registrationId = registrationId;
        this.owner = owner;
        this.parkingLot = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", owner='" + owner + '\'' +
                ", wheelCount=" + wheelCount +
                ", parkingLot=" + parkingLot +
                '}';
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public ParkingLotImpl getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotImpl parkingLot) {
        this.parkingLot = parkingLot;
    }
}
