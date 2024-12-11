package domain.policy;

import domain.user.Order;
import domain.user.Wallet;
import java.util.List;

public class QuantityDiscount {

    /**
     * 수량이 10개가 넘는지 확인해야함
     */
    public boolean isValid(List<Order> orders) {
        int purchaseQuantity = 0;
        for (Order order : orders) {
            purchaseQuantity += order.getQuantity();
        }
        if (purchaseQuantity >= 10) {
            return true;
        }
        return false;
    }

    public void apply(List<Order> orders, Wallet wallet) {
        int purchaseQuantity = 0;
        for (Order order : orders) {
            purchaseQuantity += order.getQuantity();
        }

        int discountAmount = (purchaseQuantity / 10) * 10000;
        wallet.minusAmount(discountAmount);
    }
    
}
