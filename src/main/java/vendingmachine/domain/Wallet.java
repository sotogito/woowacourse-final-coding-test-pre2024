package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;

public class Wallet {
    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public EnumMap<Coin, Integer> getReturnChange(VendingMachine vendingMachine) {
        return vendingMachine.calculateReturnChange(amount);
    }

    public boolean isOverMinimumPriceProduct(VendingMachine vendingMachine) {
        return vendingMachine.isOverMinimumPriceProduct(amount);
    }

    public void decreaseAmount(Product product) {
        amount -= product.getPrice();
    }

    @Override
    public String toString() {
        String printout = "투입 금액: %,d원\n";
        return String.format(printout, amount);
    }
}
