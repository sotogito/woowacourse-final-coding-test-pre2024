package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;

public class RandomCoinMaker implements VendingMachineCoinMaker {
    @Override
    public EnumMap<Coin, Integer> make(int amount) {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);

        while (amount > 0) {
            for (Coin coin : Coin.values()) {
                int coinAmount = coin.getAmount();
                if (coinAmount <= amount) {
                    int maxCoinCount = amount / coinAmount;
                    int randomCount = Randoms.pickNumberInRange(0, maxCoinCount);

                    if (randomCount == 0) {
                        continue;
                    }

                    result.merge(coin, randomCount, Integer::sum);
                    amount -= (randomCount * coinAmount);
                }
            }
        }
        return result;
    }

}
