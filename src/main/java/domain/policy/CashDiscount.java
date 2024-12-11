package domain.policy;

import domain.constants.Payment;
import domain.user.Wallet;

public class CashDiscount {
    /**
     * 현금을 사용했는지를 확인해야함
     */

    public boolean isValid(Payment payment) {
        if (payment.equals(Payment.CASH)) {
            return true;
        }
        return false;
    }

    public void apply(Wallet wallet) {
        wallet.discountByPercentage(0.05);
    }


}
