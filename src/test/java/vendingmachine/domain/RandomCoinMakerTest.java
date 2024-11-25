package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import org.junit.jupiter.api.Test;

class RandomCoinMakerTest {
    private RandomCoinMaker randomCoinMaker = new RandomCoinMaker();

    @Test
    void make() {
        EnumMap<Coin, Integer> result = randomCoinMaker.make(1010);
        int amount = 0;
        for (EnumMap.Entry<Coin, Integer> entry : result.entrySet()) {
            Coin coin = entry.getKey();
            int count = entry.getValue();
            amount += count * coin.getAmount();
        }

        assertEquals(1010, amount);
    }

}