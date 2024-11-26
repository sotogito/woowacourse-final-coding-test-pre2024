package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.domain.cashier.Cashier;
import vendingmachine.domain.coin.Coin;

public class Wallet {
    private int amount;

    public Wallet(int amount) {
        validatePurchaseAmount(amount);
        this.amount = amount;
    }

    public EnumMap<Coin, Integer> getReturnChange(VendingMachine vendingMachine, Cashier cashier) {
        return vendingMachine.calculateReturnChange(amount, cashier);
    }

    public boolean isOverMinimumPriceProduct(VendingMachine vendingMachine) {
        return vendingMachine.isOverMinimumPriceProduct(amount);
    }

    public void decreaseAmount(Product product) {
        amount -= product.getPrice();
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("0원 이상 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        String printout = "투입 금액: %d원\n";
        return String.format(printout, amount);
    }
}
