package vendingmachine.domain.cashier;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;

public interface Cashier {

    EnumMap<Coin, Integer> getChange(int amount, EnumMap<Coin, Integer> vendingMachineCoins);

}
