package vendingmachine.domain.coin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    COIN_1000(1000),
    ;

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static EnumMap<Coin, Integer> init() {
        EnumMap<Coin, Integer> map = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            map.put(coin, 0);
        }
        return map;
    }

    //note 내림차순이 되도록
    public static List<Integer> getAmountList() {
        List<Integer> result = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            result.add(coin.getAmount());
        }
        result.sort(Comparator.reverseOrder());
        return result;
    }

    public static Coin findByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == amount) {
                return coin;
            }
        }
        return null;
    }

    public static final Comparator<Coin> BY_VALUE_ASC = Comparator.comparingInt(Coin::getAmount);
    public static final Comparator<Coin> BY_VALUE_DESC = Comparator.comparingInt(Coin::getAmount).reversed();

}
