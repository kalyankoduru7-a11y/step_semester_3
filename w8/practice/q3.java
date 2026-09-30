abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {

    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Main {
    public static void main(String[] args) {

        Delivery[] deliveries = {
            new StandardDelivery(10, 50),
            new ExpressDelivery(5, 20),
            new InternationalDelivery(20, 100, 30)
        };

        double total = 0;

        for (Delivery d : deliveries) {

            double fee = d.calculateFee();

            if (d instanceof StandardDelivery) {
                System.out.printf("STANDARD: %.2f%n", fee);
            } else if (d instanceof ExpressDelivery) {
                System.out.printf("EXPRESS: %.2f%n", fee);
            } else {
                System.out.printf("INTERNATIONAL: %.2f%n", fee);
            }

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
