package lotto.domain;

public class RateOfReturnCalculator {
    public float calculate(int purchaseAmount, int prizeAmount) {
        return (float) prizeAmount / purchaseAmount * 100;
    }
}
