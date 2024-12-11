package domain.constants;

public enum Payment {
    CARD(1),
    CASH(2);
    private final int value;

    Payment(int value) {
        this.value = value;
    }

    public static Payment find(int value) {
        for (Payment payment : values()) {
            if (payment.value == value) {
                return payment;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 결재 방법입니다");
    }
}
