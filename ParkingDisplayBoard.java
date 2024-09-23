package design_quest_sept.parking_lot;
import java.util.*;
public class ParkingDisplayBoard {
    public void update(Map<ParkingSpotType,Integer> freeSpots) {
        for(ParkingSpotType spotType : freeSpots.keySet())
        {
            System.out.println(spotType+" avalibale: "+freeSpots.get(spotType));
        }
    }
}
