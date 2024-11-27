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
                    int maxCoinCount = amount / coinAmount; //최고 동전 개수
                    int randomCount = Randoms.pickNumberInRange(0, maxCoinCount); //아예 갖지 않는 0과 최고 동전 개수중 랜덤

                    result.merge(coin, randomCount, Integer::sum); //해당 코인과 수량을 merge로 누적
                    amount -= (randomCount * coinAmount);
                }
            }
        }
        return result;
    }
     */


}
