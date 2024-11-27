package vendingmachine.domain.coin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CoinTest {


    @Test
    void 동전_가격_내림차순_리스트_반환() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(500, 100, 50, 10));
        List<Integer> actual = Coin.getAmountList();
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    
}