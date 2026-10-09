```java
import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50.0;
    double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 2.0;
    }
}

class Train extends Booking {
    Train(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2500 + distanceKm * 4.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;
                case "TRAIN":
                    booking = new Train(distance);
                    break;
                case "FLIGHT":
                    booking = new Flight(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.calculateTotal());
        }

        sc.close();
    }
}
```
