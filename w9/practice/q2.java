```java
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;

            switch (type) {
                case "FULLTIME":
                    staff = new FullTime(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    staff = new Hourly(name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    staff = new Intern(name, sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }

            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", staff.name, pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
```
