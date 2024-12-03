package christmas.domain;

public class Order {
    private final MenuItem menuItem;
    private final int quantity;

    public Order(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return menuItem.calculateAmountByQuantity(quantity);
    }


}
