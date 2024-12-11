package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.user.Cart;
import domain.user.Order;

public class OrderService {
    private final TableRepository tableRepository;
    private final MenuRepository menuRepository;
    private final Cart cart;

    public OrderService(Cart cart, TableRepository tableRepository, MenuRepository menuRepository) {
        this.cart = cart;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
    }

    public Table getTable(int tableNumber) {
        return tableRepository.find(tableNumber);
    }

    public Menu getMenu(int menuNumber) {
        return menuRepository.find(menuNumber);
    }

    public void order(Table table, Menu menu, int quantity) {
        Order newOrder = new Order(menu, quantity);
        cart.addOrder(table, newOrder);
    }

}

