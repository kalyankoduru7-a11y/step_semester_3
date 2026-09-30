import java.util.*;
import java.util.function.IntFunction;

abstract class Vehicle {
    protected final int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract String label();
    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int h) { super(h); }
    String label() { return "BIKE"; }
    double charge() { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car(int h) { super(h); }
    String label() { return "CAR"; }
    double charge() { return 30.0 + 20.0 * (hours - 1); }
}

class Truck extends Vehicle {
    Truck(int h) { super(h); }
    String label() { return "TRUCK"; }
    double charge() { return Math.max(100.0, 50.0 * hours); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, IntFunction<Vehicle>> factory = new HashMap<>();
        factory.put("BIKE", Bike::new);
        factory.put("CAR", Car::new);
        factory.put("TRUCK", Truck::new);

        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hrs = sc.nextInt();
            list.add(factory.get(type).apply(hrs));
        }

        double total = 0;
        for (Vehicle v : list) {
            double c = v.charge();
            total += c;
            System.out.println(v.label() + ": " + String.format(Locale.US, "%.2f", c));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
