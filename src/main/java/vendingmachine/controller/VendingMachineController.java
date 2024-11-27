package vendingmachine.controller;

import vendingmachine.domain.ProductParser;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.Wallet;
import vendingmachine.service.OrderService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class VendingMachineController {
    private VendingMachineService vendingMachineService;
    private OrderService orderService;

    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachineService = new VendingMachineService(vendingMachine);
        setVendingMachine(vendingMachine);

        Wallet wallet = createWallet();
        orderService = new OrderService(vendingMachine, wallet);
        loopBuy(wallet);

        Output.printBalance(wallet);
        Output.printReturnChanges(orderService.calculateReturnChange());
    }

    private void loopBuy(Wallet wallet) {
        try {
            while (!orderService.isEndPurchase()) {
                Output.printBalance(wallet);
                tryBuy();
            }
        } catch (IllegalArgumentException e) {
            Output.printError(e.getMessage());
        }
    }

    private void tryBuy() {
        while (true) {
            try {
                orderService.buy(Input.inputPurchaseProduct());
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Wallet createWallet() {
        while (true) {
            try {
                return new Wallet(Input.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void setVendingMachine(VendingMachine vendingMachine) {
        setVendingMachineMoney();
        Output.printVendingMachineCoins(vendingMachine);
        setVendingMachineProducts();
    }

    private void setVendingMachineProducts() {
        ProductParser productParser = new ProductParser();

        while (true) {
            try {
                vendingMachineService.setProducts(productParser.parse(Input.inputVendingMachineProduct()));
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void setVendingMachineMoney() {
        while (true) {
            try {
                vendingMachineService.setMoney(Input.inputVendingMachineAmount());
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
