package design_quest_sept.parking_lot;

public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType ;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
    public String getVehicleNumber() {
        return this.licenseNumber;
    }
    

}
