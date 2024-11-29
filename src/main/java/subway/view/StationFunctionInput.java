package subway.view;

import java.util.Scanner;

public class StationFunctionInput {
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String inputDeleteStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

}
