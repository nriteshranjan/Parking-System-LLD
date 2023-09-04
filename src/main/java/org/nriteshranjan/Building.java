package org.nriteshranjan;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int buildingNumber;
    private final int maxFloors;
    private List<Floor> floors;

    public Building(int buildingNumber, int maxFloors) {
        this.buildingNumber = buildingNumber;
        this.maxFloors = maxFloors;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        if (floors.size() >= maxFloors) {
            throw new IllegalArgumentException("Maximum number of floors reached");
        }
        floor.setFloorNumber(floors.size());
        floors.add(floor);
    }

    public int getBuildingNumber() {
        return this.buildingNumber;
    }

    private List<ParkingLotImpl> getAvailableLotsFloorWise(int wheelCount, int floorNumber) {
        return this.floors.get(floorNumber).getAvailableLots(wheelCount);
    }

    public List<ParkingLotImpl> getAvailableLots(int wheelCount) {
        List<ParkingLotImpl> availableLots = new ArrayList<>();
        for (Floor floor : this.floors) {
            availableLots.addAll(getAvailableLotsFloorWise(wheelCount, floor.getFloorNumber()));
        }
        return availableLots;
    }
}
