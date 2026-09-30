abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount;
    }
}

public class Main {
    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };

        double total = 0;

        for (Payment p : payments) {
            double result = p.calculateAmount();

            if (p instanceof CardPayment) {
                System.out.printf("CARD: %.2f%n", result);
            } else if (p instanceof WalletPayment) {
                System.out.printf("WALLET: %.2f%n", result);
            } else {
                System.out.printf("BANKTRANSFER: %.2f%n", result);
            }

            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
