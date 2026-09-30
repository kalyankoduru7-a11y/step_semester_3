import java.util.*;
import java.util.function.BiFunction;

abstract class Employee {
    protected final String name;
    protected final double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }
    String getName() { return name; }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000.0; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, Double, Employee>> factory = new HashMap<>();
        factory.put("FULLTIME", FullTime::new);
        factory.put("PARTTIME", PartTime::new);
        factory.put("INTERN", Intern::new);

        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double sal = sc.nextDouble();
            list.add(factory.get(type).apply(name, sal));
        }

        double total = 0;
        for (Employee e : list) {
            double b = e.bonus();
            total += b;
            System.out.println(e.getName() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format(Locale.US, "%.2f", total));
    }
}
