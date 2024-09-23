package design_quest_sept.parking_lot;
import java.util.*;
public class ParkingFloor {
    private String floorNumber;
    private Map<ParkingSpotType,List<ParkingSpot>> parkingSpots;
    private ParkingDisplayBoard displayBoard;
    public ParkingFloor(String floorNumber, Map<ParkingSpotType,List<ParkingSpot>> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
        this.displayBoard = new ParkingDisplayBoard();
    }
    public ParkingSpotType getParkingSpot(VehicleType vehicleType) {
        if (vehicleType.equals(vehicleType.BIKE))
            return ParkingSpotType.TWOWHLEER;
        if (vehicleType.equals(vehicleType.CAR))
            return ParkingSpotType.COMPACT;
        if (vehicleType.equals(vehicleType.TRUCK))
            return ParkingSpotType.LARGE;
        return null;
    }
    public ParkingSpot getReleaventParkingSpot(Vehicle vehicle)
    {
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingSpotType parkingSpotType = getParkingSpot(vehicleType);
        System.out.println(parkingSpotType);
        List<ParkingSpot> spots = parkingSpots.get(parkingSpotType);
        ParkingSpot spot = null;
        for(ParkingSpot ps : spots)
        {
            if(ps.isFree()) {
                spot = ps;
                ps.parkVehicle(vehicle);
                updateDisplayBoard();
                break;
            }
        }
        return spot;

    }
    public void updateDisplayBoard()
    {
        Map<ParkingSpotType, Integer> freeSpotsCount = new HashMap<>();
        for (Map.Entry<ParkingSpotType, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            ParkingSpotType spotType = entry.getKey();
            List<ParkingSpot> spots = entry.getValue();
            int count = 0;
            for (ParkingSpot ps : spots) {
                if (ps.isFree()) {
                    count++;
                }
            }
            freeSpotsCount.put(spotType, count);
        }
        displayBoard.update(freeSpotsCount);
    }
   
}
