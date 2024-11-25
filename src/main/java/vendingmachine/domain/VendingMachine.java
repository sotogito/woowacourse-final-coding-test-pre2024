package vendingmachine.domain;

import java.util.EnumMap;
import java.util.List;
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

    //todo while(isOverMinimumPriceProduct)
    public boolean isOverMinimumPriceProduct(int purchaseAmount) {
        Product minPriceProduct = products.minimumPriceProduct();
        return minPriceProduct.isOver(purchaseAmount);
    }

    public void addAllProducts(List<Product> newProducts) {
        products.addAllProducts(newProducts);
    }

    public void setAmount(int amount) {
        validateMinAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    public void makeCoin() {
        int totalAmount = 0;
        for (EnumMap.Entry<Coin, Integer> entry : coinMaker.make(amount).entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            totalAmount += count * coin.getAmount();

            coins.merge(coin, count, Integer::sum);
        }
        if (totalAmount != amount) {
            throw new IllegalStateException("자판기 동전 생성 오류");
        }
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
        String coinPrintout = "%,d원 - %,d개\n";
        StringBuilder result = new StringBuilder();

        for (EnumMap.Entry<Coin, Integer> entry : coinMaker.make(amount).entrySet()) {
            int coinAmount = entry.getKey().getAmount();
            int count = entry.getValue();
            result.append(String.format(coinPrintout, coinAmount, count));
        }
        return result.toString();
    }

}
