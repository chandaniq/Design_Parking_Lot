package design_quest_sept.parking_lot;
public enum ParkingSpotType {
    TWOWHLEER {
        public double getPrice(int durationInHours) {
            double totalAmount = 0.0;
    
            // Calculate the fee based on duration
            if (durationInHours >= 1) {
                totalAmount += 4.0; // First hour
            }
            if (durationInHours >= 2) {
                totalAmount += 3.5; // Second hour
            }
            if (durationInHours >= 3) {
                totalAmount += 3.5; // Third hour
            }
            if (durationInHours > 3) {
                totalAmount += (durationInHours - 3) * 2.5; // Remaining hours
            }
            return totalAmount;
        }
    }, COMPACT {
        public double getPrice(int durationInHours) {
            double totalAmount = 0.0;
    
            // Calculate the fee based on duration
            if (durationInHours >= 1) {
                totalAmount += 4.0; // First hour
            }
            if (durationInHours >= 2) {
                totalAmount += 3.5; // Second hour
            }
            if (durationInHours >= 3) {
                totalAmount += 3.5; // Third hour
            }
            if (durationInHours > 3) {
                totalAmount += (durationInHours - 3) * 2.5; // Remaining hours
            }
            return totalAmount;
        }
    }, LARGE {
        public double getPrice(int durationInHours) {
            double totalAmount = 0.0;
    
            // Calculate the fee based on duration
            if (durationInHours >= 1) {
                totalAmount += 4.0; // First hour
            }
            if (durationInHours >= 2) {
                totalAmount += 3.5; // Second hour
            }
            if (durationInHours >= 3) {
                totalAmount += 3.5; // Third hour
            }
            if (durationInHours > 3) {
                totalAmount += (durationInHours - 3) * 2.5; // Remaining hours
            }
            return totalAmount;
        }
    };
    public abstract double getPrice(int duration);
    
}
