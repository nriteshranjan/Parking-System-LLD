package org.nriteshranjan;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private int buildingNumber;
    private int maxLots;
    private List<ParkingLotImpl> parkingLots;

    public Floor(int buildingNumber, int maxLots) {
        this.buildingNumber = buildingNumber;
        this.maxLots = maxLots;
        this.parkingLots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getBuildingNumber() {
        return this.buildingNumber;
    }

    public int getMaxLots() {
        return this.maxLots;
    }

    public List<ParkingLotImpl> getParkingLots() {
        return this.parkingLots;
    }

    public void addLots(ParkingLotImpl parkingLot) {
        if (parkingLots.size() >= maxLots) {
            throw new IllegalArgumentException("Maximum number of lots that can be accommodated has reached");
        }
        this.parkingLots.add(parkingLot);
    }

    public List<ParkingLotImpl> getAvailableLots(int wheelCount) {
        List<ParkingLotImpl> availableLots = new ArrayList<>();
        for (ParkingLotImpl parkingLot : this.parkingLots) {
            if (parkingLot.getForWheelCount() == wheelCount && !parkingLot.isReserved()) {
                availableLots.add(parkingLot);
            }
        }
        return availableLots;
    }

}
