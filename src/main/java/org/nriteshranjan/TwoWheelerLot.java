package org.nriteshranjan;

class TwoWheelerLot extends ParkingLotImpl {

    public TwoWheelerLot(int startTime, Location lotLocation) {
        super(startTime, lotLocation);
        this.setForWheelCount(2);
        this.setPrice(20); // price of parking a two-wheeler in the parking lot
    }

}