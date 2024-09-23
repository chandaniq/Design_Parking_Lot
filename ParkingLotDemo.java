package design_quest_sept.parking_lot;

import java.util.*;

public class ParkingLotDemo {
    public static void main(String[] args) {
        // Create parking spots
        List<ParkingSpot> compactSpots = new ArrayList<>();
        compactSpots.add(new ParkingSpot("C1", ParkingSpotType.COMPACT));
        compactSpots.add(new ParkingSpot("C2",ParkingSpotType.COMPACT));

        List<ParkingSpot> standardSpots = new ArrayList<>();
        standardSpots.add(new ParkingSpot("S1", ParkingSpotType.TWOWHLEER));
        standardSpots.add(new ParkingSpot("S2", ParkingSpotType.TWOWHLEER));

        List<ParkingSpot> largeSpots = new ArrayList<>();
        largeSpots.add(new ParkingSpot("L1", ParkingSpotType.LARGE));
        largeSpots.add(new ParkingSpot("L2",ParkingSpotType.LARGE));

        // Create a map for parking spots categorized by type
        Map<ParkingSpotType, List<ParkingSpot>> parkingSpots = new HashMap<>();
        parkingSpots.put(ParkingSpotType.COMPACT, compactSpots);
        parkingSpots.put(ParkingSpotType.TWOWHLEER, standardSpots);
        parkingSpots.put(ParkingSpotType.LARGE, largeSpots);

        // Create a parking floor with the parking spots
        ParkingFloor floor1 = new ParkingFloor("1", parkingSpots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);

        // Create the parking lot
        ParkingLot parkingLot = ParkingLot.getInstance("Main Parking Lot", new Address("123 Main St", "Bangalore", "Karnataka", "India", "500000"), floors);

        // Create vehicles
        Vehicle car1 = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("BIKE001", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("TRK789", VehicleType.TRUCK);

        // Park vehicles
        ParkingTicket ticket1 = parkingLot.assignTicket(car1);
        ParkingTicket ticket2 = parkingLot.assignTicket(bike1);
        ParkingTicket ticket3 = parkingLot.assignTicket(truck1);

        // Print out tickets
        System.out.println("Tickets assigned:");
        if (ticket1 != null) {
            System.out.println("Car Ticket: " + ticket1.getParkingSpot().getParkingSpotType() + " - " + car1.getVehicleNumber());
        }
        if (ticket2 != null) {
            System.out.println("Bike Ticket: " + ticket2.getParkingSpot().getParkingSpotType() + " - " + bike1.getVehicleNumber());
        }
        if (ticket3 != null) {
            System.out.println("Truck Ticket: " + ticket3.getParkingSpot().getParkingSpotType() + " - " + truck1.getVehicleNumber());
        }

        // Simulate payment for one vehicle
        if (ticket1 != null) {
            double amountPaid = parkingLot.pay(ticket1);
            System.out.println("Payment for " + car1.getVehicleNumber() + ": $" + amountPaid);
        }

        // Check availability after parking and leaving one vehicle
        System.out.println("Available spots after leaving the car:");
        for (ParkingFloor floor : floors) {
            floor.updateDisplayBoard(); // Assume this method exists to display free spots
        }
    }
}

