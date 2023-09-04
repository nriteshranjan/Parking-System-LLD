package org.nriteshranjan;

public class ParkingLotFactory {
    public static ParkingLotImpl createParkingLot(int wheelCount, int startTime, Location lotLocation) {
        if (wheelCount == 2) {
            return new TwoWheelerLot(startTime, lotLocation);
        } else if (wheelCount == 4) {
            return new FourWheelerLot(startTime, lotLocation);
        } else {
            // Handle other cases or throw an exception for invalid wheel counts
            throw new IllegalArgumentException("Invalid wheel count: " + wheelCount);
        }
    }
}
