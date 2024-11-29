package subway.view;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

}
