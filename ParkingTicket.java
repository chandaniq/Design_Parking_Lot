package design_quest_sept.parking_lot;

public class ParkingTicket {
    private String ticketNumber;
    private long issueTime;
    private long payTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
        this.ticketNumber =  vehicle.getVehicleNumber() + System.currentTimeMillis();
        this.issueTime = System.currentTimeMillis();
        this.vehicle =  vehicle;
        this.parkingSpot = parkingSpot;
    }
    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
    public long getIssueTime() {
        return this.issueTime;
    }

}
