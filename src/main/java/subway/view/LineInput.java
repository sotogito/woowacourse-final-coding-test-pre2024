package subway.view;

import java.util.Scanner;

public class LineInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputAddLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputUpStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDownStationName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDeleteLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
