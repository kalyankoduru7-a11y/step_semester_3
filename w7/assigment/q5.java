// Problem 5: The Shopping Cart

class Cart {

    private double[] prices;
    private int itemCount;
    private final String cartId;

    Cart(String cartId, int size) {
        this.cartId = cartId;
        prices = new double[size];
        itemCount = 0;
    }

    void addItem(double price) {

        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }
}

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}
