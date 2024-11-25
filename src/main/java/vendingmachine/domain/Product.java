package vendingmachine.domain;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        validateMinPrice(price);
        validatePriceUnit(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isSameName(String orderName) {
        return this.name.equals(orderName);
    }

    public void decreaseQuantity(int orderQuantity) {
        quantity -= orderQuantity;
    }

    public boolean isOver(final int purchaseAmount) {
        return price >= purchaseAmount;
    }

    public boolean isSoldOut() {
        return quantity <= 0;
    }


    private void validateMinPrice(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("상품의 최소 금액은 100원 입니다.");
        }
    }

    private void validatePriceUnit(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("상품의 금액은 10원 단위로 입력홰주세요.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.price, other.price);
    }

}
