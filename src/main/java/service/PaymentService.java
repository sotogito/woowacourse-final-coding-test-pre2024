package service;

import domain.Table;
import domain.TableRepository;
import domain.constants.Payment;
import domain.policy.DiscountApplier;
import domain.user.Cart;
import domain.user.Order;
import domain.user.Wallet;
import java.util.List;

public class PaymentService {
    private final TableRepository tableRepository;
    private final Cart cart;
    private final DiscountApplier discountApplier;


    public PaymentService(Cart cart, TableRepository tableRepository) {
        this.cart = cart;
        this.tableRepository = tableRepository;
        this.discountApplier = new DiscountApplier();
    }

    public Table findTable(int tableNumber) {
        return tableRepository.find(tableNumber);
    }

    public List<Order> findOrderByTable(Table table) {
        return cart.findOrderByTable(table);
    }

    public Wallet getPaymentAmount(List<Order> orders, Payment payment) {
        Wallet wallet = cart.getTotalAmountToWallet();
        discountApplier.applyDiscount(orders, wallet, payment);
        return wallet;
    }

    public void deleteTableOder(Table table) {
        cart.deleteTableOrders(table);
    }

}
