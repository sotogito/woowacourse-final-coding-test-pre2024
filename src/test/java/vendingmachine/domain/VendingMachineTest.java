package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class VendingMachineTest {
    private VendingMachine vendingMachine = new VendingMachine();

    @Test
    void 최소_보유_금액_예외_처리() {
        assertThatThrownBy(() -> vendingMachine.setAmount(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보규_금액_단위_예외_처리() {
        assertThatThrownBy(() -> vendingMachine.setAmount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}