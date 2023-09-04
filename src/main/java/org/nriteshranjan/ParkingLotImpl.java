package org.nriteshranjan;

import java.util.logging.Level;
import java.util.logging.Logger;

class ParkingLotImpl implements IParkingLot {

    private static final String UNPARK_FREE_LOT = "Parking lot is not reserved by anyone";
    private static final String DUE_NOT_CLEARED = "Parking lot amount is not paid. Please clear the due amount";
    private static Logger logger = Logger.getLogger(ParkingLotImpl.class.getName());
    private float price;
    private int forWheelCount;
    private boolean isReserved;
    private Integer startTime;
    private Integer endTime;
    private Object vehicle;
    private Location lotLocation;
    private boolean isPaid;


    public ParkingLotImpl(int startTime, Location lotLocation) {
        this.isReserved = false;
        this.startTime = startTime;
        this.endTime = null;
        this.vehicle = null;
        this.lotLocation = lotLocation;
        this.isPaid = false;
    }

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

    public Object getVehicle() {
        return vehicle;
    }

    public void setVehicle(Object vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public boolean parkVehicle(int startTime, Object vehicle) {
        if (isReserved()) {
            return false;
        }
        setStartTime(startTime);
        setVehicle(vehicle);
        setPaid(false);
        setReserved(true);
        return true;
    }

    @Override
    public boolean unparkVehicle(int currentTime) throws Exception {
        if (!isReserved()) {
            logger.log(Level.WARNING, UNPARK_FREE_LOT);
            throw new Exception(UNPARK_FREE_LOT);
        }

        if (!isPaid()) {
            logger.log(Level.WARNING, DUE_NOT_CLEARED);
            throw new Exception(DUE_NOT_CLEARED);
        }

        if (getEndTime() != currentTime) {
            setStartTime(getEndTime());
            setEndTime(currentTime);
            setPaid(false);
            throw new Exception(DUE_NOT_CLEARED);
        }

        setReserved(false);
        setVehicle(null);
        setStartTime(null);
        setEndTime(null);
        setPaid(false);
        return true;
    }


}