package design_quest_sept.parking_lot;
//Strategy Pattern
public interface PricingStrategy {
    double calculateFee(int parkedHours, double price);
}
