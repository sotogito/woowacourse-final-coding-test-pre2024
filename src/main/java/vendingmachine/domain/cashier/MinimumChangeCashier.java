package vendingmachine.domain.cashier;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;

public class MinimumChangeCashier implements Cashier {

    @Override
    public EnumMap<Coin, Integer> getChange(int amount, EnumMap<Coin, Integer> vendingMachineCoins) {//얘를 최소로
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);

        for (EnumMap.Entry<Coin, Integer> entry : vendingMachineCoins.entrySet()) {
            Coin coin = entry.getKey();
            int coinAmount = coin.getAmount();
            int haveCoinCount = entry.getValue();
            int maxCoinCount = Math.min((amount / coinAmount), haveCoinCount);

            if (maxCoinCount == 0) {
                continue;
            }
            vendingMachineCoins.put(coin, vendingMachineCoins.get(coin) - maxCoinCount);
            result.put(coin, maxCoinCount);
            amount -= (coinAmount * maxCoinCount);
        }
        return result;
    }

}
