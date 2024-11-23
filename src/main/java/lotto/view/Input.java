package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 숫자로 입력해주세요.");
        }
    }


    public static String inputSixLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusLotto() {
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자로 입력해주세요.");
        }
    }
}
