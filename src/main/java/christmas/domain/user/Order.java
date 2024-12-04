package christmas.domain.user;

import christmas.domain.restaurant.MenuItem;
import java.util.Objects;

public class Order {
    private final MenuItem menuItem;
    private int quantity;

    public Order(MenuItem menuItem, int quantity) {
        validateQuantity(quantity);
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(menuItem, order.menuItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItem);
    }

}
