package christmas.service;

import christmas.constant.Category;
import christmas.domain.dto.CategoryMenuDto;
import christmas.domain.dto.OrderItemDto;
import christmas.domain.restaurant.MenuItem;
import christmas.domain.singleton.Restaurant;
import christmas.domain.user.Cart;
import christmas.domain.user.Order;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class OrderService {
    private final Restaurant restaurant = Restaurant.RESTAURANT;

    public OrderService() {
    }

    public Schedule booking(int day) {
        return new Schedule(2023, 12, day);
    }

    public Cart order(List<OrderItemDto> orderItems) {
        EnumMap<Category, List<Order>> result = new EnumMap<>(Category.class);

        for (OrderItemDto orderItem : orderItems) {
            CategoryMenuDto dto = restaurant.findByMenuName(orderItem.menu());
            Category category = dto.category();
            MenuItem menuItem = dto.menuItem();
            int quantity = orderItem.quantity();

            List<Order> orders = new ArrayList<>();

            if (result.containsKey(category)) {
                orders = result.get(category);
            }

            Order order = new Order(menuItem, quantity);

            if (orders.contains(order)) {
                Order oldOrder = orders.get(orders.indexOf(order));
                oldOrder.increaseQuantity(quantity);
                continue;
            }
            
            orders.add(order);
            result.put(category, orders);
        }
        return new Cart(result);
    }

    public Wallet calculatePurchaseAmount(Cart cart) {
        int totalPurchaseAmount = cart.calculateTotalPurchaseAmount();
        Wallet wallet = new Wallet();
        wallet.setPurchaseAmount(totalPurchaseAmount);
        return wallet;
    }

}
