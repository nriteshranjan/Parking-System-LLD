package org.nriteshranjan;

interface IParkingLot {
    boolean parkVehicle(int startTime, Object vehicle);

    boolean unparkVehicle(int currentTime) throws Exception;
}