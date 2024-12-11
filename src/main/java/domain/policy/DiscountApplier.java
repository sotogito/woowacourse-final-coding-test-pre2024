package domain.policy;

import domain.constants.Payment;
import domain.user.Order;
import domain.user.Wallet;
import java.util.List;

public class DiscountApplier {
    private final QuantityDiscount quantityDiscount;
    private final CashDiscount cashDiscount;

    public DiscountApplier() {
        this.cashDiscount = new CashDiscount();
        this.quantityDiscount = new QuantityDiscount();
    }

    public void applyDiscount(List<Order> orders, Wallet wallet, Payment payment) {
        if (quantityDiscount.isValid(orders)) {
            quantityDiscount.apply(orders, wallet);
        }
        if (cashDiscount.isValid(payment)) {
            System.out.println("resf");
            cashDiscount.apply(wallet);
        }
    }

}
