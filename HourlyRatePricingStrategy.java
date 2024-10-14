package design_quest_sept.parking_lot;

public class HourlyRatePricingStrategy {
    public double calculateFee(int hoursParked, double price) {
        return price*hoursParked;
    }
}
