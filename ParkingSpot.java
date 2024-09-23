package design_quest_sept.parking_lot;

public class ParkingSpot {
    private String number;
    private boolean free;
    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;

    public ParkingSpot(String number,ParkingSpotType parkingSpotType)
    {
        this.number = number;
        this.parkingSpotType = parkingSpotType;
        free = true;
    }
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.free = false;
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.free = true;
    }
    public boolean isFree() {
        return this.free;
    }
    public ParkingSpotType getParkingSpotType() {
        return this.parkingSpotType;
    }
}
