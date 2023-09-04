package org.nriteshranjan;

class FourWheelerLot extends ParkingLotImpl {

    public FourWheelerLot(int startTime, Location lotLocation) {
        super(startTime, lotLocation);
        this.setForWheelCount(4);
        this.setPrice(30); // price of parking a two-wheeler in the parking lot
    }

}
