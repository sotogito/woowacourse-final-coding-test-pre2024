package christmas.domain.user;

public class Wallet {
    private int purchaseAmount;
    private int totalDiscountAmount;

    public Wallet() {
        this.purchaseAmount = 0;
        this.totalDiscountAmount = 0;
    }

    public boolean canEvent() {
        return purchaseAmount >= 10000;
    }

    public boolean isOverAmount(int amount) {
        return this.purchaseAmount >= amount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setTotalDiscountAmount(int totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public int getAmountAfterDiscount() {
        return purchaseAmount - totalDiscountAmount;
    }


    @Override
    public String toString() {
        return String.format("%,d원", purchaseAmount);
    }

}
