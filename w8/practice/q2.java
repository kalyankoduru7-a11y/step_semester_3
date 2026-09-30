import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    String getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(getBorrowingDays()).toString();
    }

    String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }
}

public class Main {
    public static void main(String[] args) {

        LibraryItem[] items = {
            new Book("1984"),
            new DVD("The Matrix"),
            new Magazine("Forbes Issue 500")
        };

        for (LibraryItem item : items) {
            System.out.println(
                item.getTitle() + ": " + item.getDueDate()
            );
        }
    }
}
