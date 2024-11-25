package vendingmachine.domain;

import java.util.EnumMap;

public class VendingMachine {
    private final VendingMachineCoinMaker coinMaker;

    private int amount;
    private final EnumMap<Coin, Integer> coins;

    public VendingMachine() {
        this.coinMaker = new RandomCoinMaker();
        this.coins = Coin.init();
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


}
