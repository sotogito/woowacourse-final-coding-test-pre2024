package vendingmachine.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import vendingmachine.domain.cashier.Cashier;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.RandomCoinMaker;
import vendingmachine.domain.coin.VendingMachineCoinMaker;

public class VendingMachine {
    private final VendingMachineCoinMaker coinMaker;
    private int amount;
    private final EnumMap<Coin, Integer> coins;
    private final Products products;

    public VendingMachine() {
        this.coinMaker = new RandomCoinMaker();
        this.coins = Coin.init();
        this.products = new Products();
    }

    public void makeCoin() {
        coinMaker.make(amount, coins);
    }

    public EnumMap<Coin, Integer> calculateReturnChange(int amount, Cashier cashier) {
        return cashier.getChange(amount, coins);
    }


    public Product findProductByName(String name) {
        return products.findProductByName(name);
    }

    //todo while(isOverMinimumPriceProduct)
    public boolean isOverMinimumPriceProduct(int purchaseAmount) {
        Optional<Product> minPriceProduct = products.minimumPriceProduct();
        if (minPriceProduct.isPresent()) {
            return !minPriceProduct.get().isOver(purchaseAmount);
        }
        return false;
    }

    public boolean isAllProductsSoldOut() {
        return products.isAllProductSoldOut();
    }

    public void addAllProducts(List<Product> newProducts) {
        products.addAllProducts(newProducts);
    }

    public void setAmount(int amount) {
        validateMinAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    private void validateMinAmount(int amount) {
        if (amount <= 10) {
            throw new IllegalArgumentException("자판기 보유 금액 최소 금액은 10원 입니다.");
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % 10 != 0) {
            throw new IllegalArgumentException("자판기 보유 금액을 10원 단위로 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        String coinPrintout = "%d원 - %d개\n";
        StringBuilder result = new StringBuilder();

        for (EnumMap.Entry<Coin, Integer> entry : coins.entrySet()) {
            int coinAmount = entry.getKey().getAmount();
            int count = entry.getValue();
            result.append(String.format(coinPrintout, coinAmount, count));
        }
        return result.toString();
    }

}
