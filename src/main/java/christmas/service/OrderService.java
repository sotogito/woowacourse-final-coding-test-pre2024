package christmas.service;

import christmas.constant.Category;
import christmas.domain.MenuItem;
import christmas.domain.Order;
import christmas.domain.dto.CategoryMenuDto;
import christmas.domain.dto.OrderItemDto;
import christmas.domain.singleton.Restaurant;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class OrderService {
    private final Restaurant restaurant = Restaurant.RESTAURANT;

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

            if (result.containsKey(category)) {
                List<Order> orders = result.get(category);
                //이미 있는 order 누적 수량 추가
                orders.add(new Order(menuItem, quantity));
                continue;
            }

            List<Order> orders = new ArrayList<>();
            orders.add(new Order(menuItem, quantity));
            result.put(category, orders);
        }
        return new Cart(result);
    }

}
