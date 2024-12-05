package menu.view;

import menu.domain.Coachs;
import menu.domain.WeekMenuScheduler;

public class Output {
    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    /**
     * 메뉴 추천 결과입니다. [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ] [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ] [ 토미 | 쌈밥 | 김치찌개 | 미소시루 |
     * 짜장면 | 팟타이 ] [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ] [ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]
     * <p>
     * 추천을 완료했습니다.
     */

    public static void printOneWeekMenuSchedule(WeekMenuScheduler weekMenuCategoryResult, Coachs coachs) {
        System.out.println("메뉴 추천 결과입니다.");

        System.out.print(weekMenuCategoryResult);
        System.out.print(coachs);

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

}
