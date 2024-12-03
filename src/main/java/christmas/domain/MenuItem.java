package christmas.domain;

public class MenuItem {
    private final String name;
    private final int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }

    public int calculateAmountByQuantity(int quantity) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s(%,d)", name, price);
    }

}
