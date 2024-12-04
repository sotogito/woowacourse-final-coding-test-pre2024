package christmas.domain.user;

import christmas.constant.Category;
import christmas.domain.dto.CategoryQuantityDto;
import java.util.EnumMap;
import java.util.List;

public class Cart {
    private final EnumMap<Category, List<Order>> cart;

    public Cart(EnumMap<Category, List<Order>> order) {
        validateTotalQuantity(order);
        cart = order;
    }

    /**
     * 총 수량 유효검사 카테고리에따른 수량과 가격 반환
     */

    public int calculateTotalPurchaseAmount() {
        int totalAmount = 0;
        for (List<Order> orders : cart.values()) {
            for (Order order : orders) {
                totalAmount += order.getQuantity();
            }
        }
        return totalAmount;
    }

    private void validateTotalQuantity(EnumMap<Category, List<Order>> order) {
        int totalQuantity = 0;
        for (Category category : order.keySet()) {
            List<Order> orders = order.get(category);
            for (Order orderItem : orders) {
                totalQuantity += orderItem.getQuantity();
            }
        }
        if (totalQuantity < 0 || totalQuantity > 20) {
            throw new IllegalArgumentException("주문 수량은 총 1~20까지 가능합니다.");
        }
    }

    public CategoryQuantityDto findQuantityByCategory(Category category) {
        int totalQuantity = 0;

        if (!cart.containsKey(category)) {
            return new CategoryQuantityDto(category, totalQuantity);
        }

        List<Order> orders = cart.get(category);
        for (Order order : orders) {
            totalQuantity += order.getQuantity();
        }
        return new CategoryQuantityDto(category, totalQuantity);
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();

        for (Category category : cart.keySet()) {
            List<Order> orders = cart.get(category);
            for (Order order : orders) {
                printout.append(order).append("\n");
            }
        }
        return printout.toString();
    }

}
