package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WalletTest {


    @Test
    void 최고금액_미달_예외_처리() {
        assertThatThrownBy(() -> new Wallet(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액_천단위_예외_처리() {
        assertThatThrownBy(() -> new Wallet(10002))
                .isInstanceOf(IllegalArgumentException.class);
    }

}