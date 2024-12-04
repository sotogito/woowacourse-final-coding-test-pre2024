package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputBookingDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static String inputOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        try {
            return Console.readLine().trim();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("방문 날짜는 숫자로 입력해주세요.");
        }
    }

}
