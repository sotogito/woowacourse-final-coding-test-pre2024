package vendingmachine.domain;

import java.util.EnumMap;

public interface VendingMachineCoinMaker {
    EnumMap<Coin, Integer> make(int amount);
}
