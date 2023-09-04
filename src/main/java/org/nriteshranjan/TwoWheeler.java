package org.nriteshranjan;

public class TwoWheeler extends Vehicle {

    public TwoWheeler(String name, String registrationId, String owner) {
        super(name, registrationId, owner);
        setWheelCount(2);
    }

    @Override
    public TwoWheelerLot getParkingLot() {
        return (TwoWheelerLot) this.parkingLot;
    }

    @Override
    public void setParkingLot(ParkingLotImpl parkingLot) {
        if (parkingLot instanceof TwoWheelerLot) {
            super.setParkingLot(parkingLot);
        } else {
            throw new IllegalArgumentException("Invalid parking lot type");
        }
    }
}
