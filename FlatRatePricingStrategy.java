package design_quest_sept.parking_lot;

public class FlatRatePricingStrategy implements PricingStrategy{
    private double flatRate;
    FlatRatePricingStrategy(double flatRate) {
        this.flatRate = flatRate;
    }
    public double calculateFee(int hoursParked, double price) {
        return flatRate;
    }
}
