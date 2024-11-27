package vendingmachine.service;

import java.util.EnumMap;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.Wallet;
import vendingmachine.domain.cashier.Cashier;
import vendingmachine.domain.cashier.MinimumChangeCashier;
import vendingmachine.domain.coin.Coin;

public class OrderService {
    private final VendingMachine vendingMachine;
    private final Wallet wallet;
    private final Cashier cashier;

    public OrderService(VendingMachine vendingMachine, Wallet wallet) {
        this.vendingMachine = vendingMachine;
        this.wallet = wallet;
        this.cashier = new MinimumChangeCashier();
    }


    public boolean isEndPurchase() {
        if (!wallet.isOverMinimumPriceProduct(vendingMachine)) {
            return true;
        } else if (vendingMachine.isAllProductsSoldOut()) {
            return true;
        }
        return false;
    }

    public void buy(String productName) {
        Product boughtProduct = vendingMachine.findProductByName(productName);
        if (boughtProduct.isSoldOut()) {
            throw new IllegalArgumentException("해당 상품은 재고가 없습니다.");
        }
        updateState(boughtProduct);
    }

    private void updateState(Product boughtProduct) {
        boughtProduct.decreaseQuantity(1);
        wallet.decreaseAmount(boughtProduct);
    }

    public EnumMap<Coin, Integer> calculateReturnChange() {
        return wallet.getReturnChange(vendingMachine, cashier);
    }

}
