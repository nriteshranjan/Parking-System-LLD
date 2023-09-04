package org.nriteshranjan;

public class FourWheeler extends Vehicle {

    public FourWheeler(String name, String registrationId, String owner) {
        super(name, registrationId, owner);
        setWheelCount(4);
    }
}
