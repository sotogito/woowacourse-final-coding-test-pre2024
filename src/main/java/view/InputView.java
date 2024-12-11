package view;

import domain.Table;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int input(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static int inputPaymentType(Table table) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다.\n", table.getNumber());
        return scanner.nextInt();
    }

}
