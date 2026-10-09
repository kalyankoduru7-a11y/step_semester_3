```java
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;
                case "DVD":
                    item = new DVD(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }

            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}
```
