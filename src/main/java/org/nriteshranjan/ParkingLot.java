package org.nriteshranjan;

public abstract class ParkingLot<T extends Vehicle> {
    private float price;
    private int forWheelCount;
    private boolean isReserved;
    private Integer startTime;
    private Integer endTime;
    private T vehicle;
    private Location lotLocation;
    private boolean isPaid;

    public ParkingLot(int startTime, Location lotLocation) {
        this.isReserved = false;
        this.startTime = 0;
        this.endTime = null;
        this.vehicle = null;
        this.lotLocation = lotLocation;
        this.isPaid = false;
    }

    public abstract boolean parkVehicle(int startTime, T vehicle);

    public abstract boolean unparkVehicle(int currentTime) throws Exception;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getForWheelCount() {
        return forWheelCount;
    }

    public void setForWheelCount(int forWheelCount) {
        this.forWheelCount = forWheelCount;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public Location getLotLocation() {
        return lotLocation;
    }

    public void setLotLocation(Location lotLocation) {
        this.lotLocation = lotLocation;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}