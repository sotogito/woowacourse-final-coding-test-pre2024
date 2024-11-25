package vendingmachine.domain.coin;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;

public class RandomCoinMaker implements VendingMachineCoinMaker {


    @Override
    public EnumMap<Coin, Integer> make(int amount, EnumMap<Coin, Integer> coins) {
        List<Integer> coinAmounts = Coin.getAmountList();

        while (amount > 0) {
            int randomCoin = Randoms.pickNumberInList(coinAmounts);
            if (amount >= randomCoin) {
                coins.merge(Coin.findByAmount(randomCoin), 1, Integer::sum);
                amount -= randomCoin;
            }
        }
        return coins;
    }


    /*
    @Override
    public EnumMap<Coin, Integer> make(int amount) {
        EnumMap<Coin, Integer> result = Coin.init();
        List<Integer> coinAmounts = Coin.getAmountList();

        while (amount > 0) {
            int randomCoin = Randoms.pickNumberInList(coinAmounts);

            if (amount >= randomCoin) {

                int maxCount = amount / randomCoin;
                int resultCount = Randoms.pickNumberInRange(0, maxCount);

                result.merge(Coin.findByAmount(randomCoin), resultCount, Integer::sum);
                amount -= resultCount * randomCoin;
            }
        }
        return result;
    }

     */

    //note pickNumberInRange
    /*
    @Override
    public EnumMap<Coin, Integer> make(int amount) {
        EnumMap<Coin, Integer> result = Coin.init();

        while (amount > 0) {
            for (Coin coin : Coin.values()) {
                int coinAmount = coin.getAmount();

                if (coinAmount <= amount) {
                    int maxCoinCount = amount / coinAmount;
                    int randomCount = Randoms.pickNumberInRange(0, maxCoinCount);

                    result.merge(coin, randomCount, Integer::sum);
                    amount -= (randomCount * coinAmount);
                }
            }
        }
        return result;
    }
     */


}
