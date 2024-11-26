package vendingmachine.view;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.Wallet;
import vendingmachine.domain.coin.Coin;

public class Output {

    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println("자판기가 보유한 동전");
        System.out.println(vendingMachine);
    }

    public static void printBalance(Wallet wallet) {
        System.out.print(wallet);
    }

    public static void printReturnChanges(EnumMap<Coin, Integer> returnChanges) {
        System.out.println("잔돈");
        for (Map.Entry<Coin, Integer> entry : returnChanges.entrySet()) {
            int coin = entry.getKey().getAmount();
            int count = entry.getValue();
            System.out.printf("%d원 - %d개\n", coin, count);
        }

    }


}
