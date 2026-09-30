import java.util.*;
import java.util.function.DoubleFunction;

abstract class Customer {
    protected final double amount;
    Customer(double amount) { this.amount = amount; }
    abstract String label();
    abstract double finalAmount();
}

class Student extends Customer {
    Student(double a) { super(a); }
    String label() { return "STUDENT"; }
    double finalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double a) { super(a); }
    String label() { return "STAFF"; }
    double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double a) { super(a); }
    String label() { return "GUEST"; }
    double finalAmount() { return amount + 10; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, DoubleFunction<Customer>> factory = new HashMap<>();
        factory.put("STUDENT", Student::new);
        factory.put("STAFF", Staff::new);
        factory.put("GUEST", Guest::new);

        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amt = sc.nextDouble();
            bills.add(factory.get(type).apply(amt));
        }

        double total = 0;
        for (Customer c : bills) {
            double f = c.finalAmount();
            total += f;
            System.out.println(c.label() + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
