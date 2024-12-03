package christmas.domain;

import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;

public class EventPlanner {
    private final Schedule schedule;
    private final Cart cart;
    private final Wallet wallet;

    public EventPlanner(Schedule schedule, Cart cart, Wallet wallet) {
        this.schedule = schedule;
        this.cart = cart;
        this.wallet = wallet;
    }

    public void setTotalPurchaseAmount() {
        int totalPurchaseAmount = cart.calculateTotalPurchaseAmount();
        wallet.setPurchaseAmount(totalPurchaseAmount);
    }

    public void calculateDiscount() {

    }


}
