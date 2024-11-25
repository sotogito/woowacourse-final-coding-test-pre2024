package vendingmachine.domain.coin;

import java.util.EnumMap;

public interface VendingMachineCoinMaker {
    EnumMap<Coin, Integer> make(int amount);
}
