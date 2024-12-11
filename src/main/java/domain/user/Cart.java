package domain.user;

import domain.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<Table, List<Order>> orders;

    public Cart() {
        this.orders = new HashMap<>();
    }

    public void deleteTableOrders(Table table) {
        orders.remove(table);
    }

    public Wallet getTotalAmountToWallet() {
        int totalAmount = 0;
        for (List<Order> orderList : orders.values()) {
            for (Order order : orderList) {
                totalAmount += order.getAmount();
            }
        }
        return new Wallet(totalAmount);
    }

    public List<Order> findOrderByTable(Table table) {
        if (orders.containsKey(table)) {
            return orders.get(table);
        }
        throw new IllegalArgumentException("주문이 존재하지 않는 테이블입니다.");
    }

    //note Cart에서 알아서 추가로직을 해주는에 역할이 맞다.
    public void addOrder(Table table, Order order) {
        if (orders.containsKey(table)) {
            List<Order> oldOrders = orders.get(table);

            if (oldOrders.contains(order)) {
                for (Order oldOrder : oldOrders) {
                    if (oldOrder.equals(order)) {
                        oldOrder.addQuantity(order); //note 존재하는 테이블에, 이미 있는 주문의 수량만 추가
                        return;
                    }
                }
            }
            oldOrders.add(order); //note 존재하는 테이블에 새로운 주문만 추가
            return;
        }
        orders.put(table, new ArrayList<>(List.of(order))); //note 아예 새로운 테이블 주문
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Table, List<Order>> entry : orders.entrySet()) {
            Table table = entry.getKey();
            List<Order> orders = entry.getValue();

            result.append(String.format("%s 테이블\n", table.getNumber()));
            for (Order order : orders) {
                result.append(String.format("주문 : %s\n", order));
            }
        }
        return result.toString();
    }

}
