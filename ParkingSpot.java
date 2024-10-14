
package design_quest_sept.parking_lot;
import java.util.*;
public class ParkingSpot implements Observable{
    private String number;
    private boolean free;
    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private List<Observer> observers;

    public ParkingSpot(String number,ParkingSpotType parkingSpotType)
    {
        this.number = number;
        this.parkingSpotType = parkingSpotType;
        free = true;
        this.observers = new ArrayList<>();
    }
    public void parkVehicle(Vehicle vehicle) {
        System.out.println("Vehicle Assigned");
        this.vehicle = vehicle;
        this.free = false;
        notifyObservers();
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.free = true;
        System.out.println("Vehicle Removed");
        notifyObservers();
        
    }
    public boolean isFree() {
        return this.free;
    }
    public ParkingSpotType getParkingSpotType() {
        return this.parkingSpotType;
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        System.out.println("Sent Notification to all Floor");
        for (Observer observer: observers) {
            observer.update();
        }
    }

}
