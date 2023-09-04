package org.nriteshranjan;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ServiceClass {
    private static final Logger logger = Logger.getLogger(ServiceClass.class.getName());
    private List<Building> buildings;

    public ServiceClass() {
        this.buildings = new ArrayList<>();
    }

    public Building createBuilding(int buildingNumber, int maxFloors, List<Floor> floors) {
        Building building = new Building(buildingNumber, maxFloors);
        for (Floor floor : floors) {
            building.addFloor(floor);
        }
        buildings.add(building);
        return building;
    }

    public Floor createFloor(Building building, int maxLots) {
        Floor floor = new Floor(building.getBuildingNumber(), maxLots);
        building.addFloor(floor);
        return floor;
    }

    public <T extends ParkingLotImpl> T createParkingLot(int wheelCount, int startTime, Location lotLocation, Class<T> clazz) {
        try {
            ParkingLotImpl parkingLot = ParkingLotFactory.createParkingLot(wheelCount, startTime, lotLocation);
            // Add the created parking lot to your management system, e.g., store it in a list or database
            // buildings.add(parkingLot);
            return clazz.cast(parkingLot);
        } catch (IllegalArgumentException e) {
            logger.warning("Parking lot creation failed: " + e.getMessage());
            return null;
        }
    }

    public List<ParkingLotImpl> getAvailableLots(int wheelCount, int buildingNumber) {
        List<ParkingLotImpl> availableLots = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getBuildingNumber() == buildingNumber) {
                availableLots.addAll(building.getAvailableLots(wheelCount));
            }
        }
        return availableLots;
    }

    public boolean reserveLot(ParkingLotImpl parkingLotImpl, int startTime, Vehicle vehicle) {
        try {
            parkingLotImpl.parkVehicle(startTime, vehicle);
            vehicle.setParkingLot(parkingLotImpl);
            return true;
        } catch (Exception e) {
            logger.warning("Reservation failed: " + e.getMessage());
            return false;
        }
    }

    private int getCurrentTime() {
        // Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Convert the current time to an integer (if needed)
        int currentTimeInSeconds = (int) (currentTimeMillis / 1000);
        return currentTimeInSeconds;
    }

    public boolean freeLot(ParkingLotImpl parkingLotImpl, int endTime, ClientDetails clientDetails, String paymentMode) {
        try {
            // Step 1: Set the end time of the parking lot
            parkingLotImpl.setEndTime(getCurrentTime());

            // Step 2: Calculate the parking fee
            float amount = calculateAmount(parkingLotImpl.getStartTime(), parkingLotImpl.getEndTime(), parkingLotImpl.getPrice());

            // Step 3: Make payment
            boolean paymentSuccessful = makePayment(amount, clientDetails, paymentMode);
            if (paymentSuccessful) {
                // Step 4: Unpark the vehicle from the parking lot
                boolean result = parkingLotImpl.unparkVehicle(endTime);

                if (result) {
                    return true; // Parking lot freed successfully
                } else {
                    logger.warning("Parking lot could not be freed.");
                    return false;
                }
            } else {
                logger.warning("Payment was not successful. Parking lot will not be freed.");
                return false;
            }
        } catch (Exception e) {
            logger.warning("Parking lot could not be freed: " + e.getMessage());
            return false;
        }
    }

    private float calculateAmount(Integer startTime, Integer endTime, float price) {
        return (endTime - startTime) * price;
    }

    public boolean makePayment(float amount, ClientDetails clientDetails, String paymentMode) {
        // Check if payment details are captured and valid
        if (clientDetails == null || paymentMode == null) {
            logger.warning("Payment failed due to invalid details.");
            return false;
        }

        // Implement payment logic, e.g., using a payment service
        PaymentService paymentService = new PaymentService(3);
        paymentService.startSessionAndMakePayment(paymentMode, clientDetails, amount);

        // Assuming the payment logic is successful
        return true;
    }
}
