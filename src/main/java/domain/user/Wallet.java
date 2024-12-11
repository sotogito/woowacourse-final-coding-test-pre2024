package domain.user;

public class Wallet {
    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public void minusAmount(int discountAmount) {
        amount -= discountAmount;
    }

    public void discountByPercentage(double percentage) {
        amount = (int) (amount - (amount * percentage));
    }

    @Override
    public String toString() {
        return amount + "";
    }

}
