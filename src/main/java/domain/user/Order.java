package domain.user;

import domain.Menu;
import java.util.Objects;

public class Order {
    private final Menu menu;
    private int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return menu.calculateAmountByQuantity(quantity);
    }

    public void addQuantity(Order other) {
        this.quantity += other.quantity;
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
        return Objects.equals(menu, order.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d\n", menu.getName(), quantity, menu.calculateAmountByQuantity(quantity));
    }

}
