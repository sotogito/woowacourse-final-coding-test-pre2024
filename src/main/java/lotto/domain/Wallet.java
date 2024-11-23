package lotto.domain;

public class Wallet {
    private final int amount;
    private float rateOfReturn;

    public Wallet(int amount) {
        validateMinimum(amount);
        validateUnit(amount);
        this.amount = amount;
        this.rateOfReturn = 0;
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }

    public void calculateRateOfReturn(RateOfReturnCalculator calculator, int prizeAmount) {
        rateOfReturn = calculator.calculate(amount, prizeAmount);
    }

    private void validateMinimum(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("구매 최소 금액은 1,000원 입니다.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    public void calculateTicket(Ticket ticket) {
        ticket.setTicketNumber(amount);
    }
}

