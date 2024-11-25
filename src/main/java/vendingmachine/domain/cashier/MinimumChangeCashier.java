package vendingmachine.domain.cashier;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;

public class MinimumChangeCashier implements Cashier {

    @Override
    public EnumMap<Coin, Integer> getChange(int amount, EnumMap<Coin, Integer> coins) {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);

        for (EnumMap.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int coinAmount = coin.getAmount();
            int haveCoinCount = entry.getValue();
            int maxCoinCount = amount / coinAmount;

            if (maxCoinCount > haveCoinCount) {
                maxCoinCount = haveCoinCount;
            }
            if (maxCoinCount == 0) {
                continue;
            }
            coins.put(coin, coins.get(coin) - maxCoinCount);
            result.put(coin, maxCoinCount);
            amount -= (coinAmount * maxCoinCount);
        }
        return result;
    }

}
