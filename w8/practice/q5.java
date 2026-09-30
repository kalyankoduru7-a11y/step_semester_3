abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Main {
    public static void main(String[] args) {

        Transport[] transports = {
            new Bus(15),
            new Train(50),
            new Metro(10, 1.5)
        };

        double total = 0;

        for (Transport t : transports) {

            double fare = t.calculateFare();

            if (t instanceof Bus) {
                System.out.printf("BUS: %.2f%n", fare);
            } else if (t instanceof Train) {
                System.out.printf("TRAIN: %.2f%n", fare);
            } else {
                System.out.printf("METRO: %.2f%n", fare);
            }

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
