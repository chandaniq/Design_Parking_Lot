package design_quest_sept.parking_lot;
import java.util.*;
public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkinglot;

    private ParkingLot(String name, Address address, List<ParkingFloor> parkingFloors) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;

    }
    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> parkingFloors) {
        if(parkinglot == null)
        {
            parkinglot = new ParkingLot(name, address, parkingFloors);
        }
        return parkinglot;
    }
    public ParkingTicket assignTicket(Vehicle vehicle) {
        ParkingSpot spot = getParkingSpotAndPark(vehicle);
        if(spot == null)
            return null;
        ParkingTicket ticket = new ParkingTicket(vehicle, spot);
        return ticket;

    }
    public double pay(ParkingTicket ticket) {
        long payTime = System.currentTimeMillis();
        int duration = (int)(payTime-ticket.getIssueTime())/1000;
        int durationInHours = (int) Math.ceil(duration / 3600.0); // Total duration in hours
        double price = ticket.getParkingSpot().getParkingSpotType().getPrice(durationInHours);

        // Remove the vehicle and return the total amount
        ticket.getParkingSpot().removeVehicle();
        return price;

    }
    public ParkingSpot getParkingSpotAndPark(Vehicle vehicle) {
        ParkingSpot spot = null;
        for (ParkingFloor floor : parkingFloors)
        {
            spot = floor.getReleaventParkingSpot(vehicle);
            if(spot != null)
                break;   
        }
        return spot;
    }


}
