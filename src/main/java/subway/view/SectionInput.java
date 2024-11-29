package subway.view;

import java.util.Scanner;

public class SectionInput {
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputAddLineNameInSection() {
        System.out.println("## 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputAddStationNameInSection() {
        System.out.println("## 역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static int inputAddOrderInSection() {
        System.out.println("## 순서를 입력하세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("순서는 숫자로 입력해주세요.");
        }
    }

    public static String inputDeleteLineNameInSection() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDeleteStationNameInSection() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine();
    }
}
