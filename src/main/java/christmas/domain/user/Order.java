package christmas.domain.user;

import christmas.domain.restaurant.MenuItem;

public class Order {
    private final MenuItem menuItem;
    private final int quantity;

    public Order(MenuItem menuItem, int quantity) {
        validateQuantity(quantity);
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return menuItem.calculateAmountByQuantity(quantity);
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("최소 수량은 1개 입니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menuItem.getName(), quantity);
    }

}
