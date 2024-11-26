package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputVendingMachineAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자판기 보유 금액은 숫자로 입력해주세요.");
        }
    }


    public static String inputVendingMachineProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputPurchaseAmount() {
        System.out.println("투입 금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("투입 금액은 숫자로 입력해주세요.");
        }
    }

    public static String inputPurchaseProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

}
