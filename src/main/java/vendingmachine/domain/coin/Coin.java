package vendingmachine.domain.coin;

import java.util.EnumMap;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

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

    // 추가 기능 구현
}
