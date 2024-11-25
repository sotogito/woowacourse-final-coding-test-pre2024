package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    private final VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    public void setMoney(int amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.makeCoin();
    }

    public void setProducts(List<Product> products) {
        vendingMachine.addAllProducts(products);
    }

}
