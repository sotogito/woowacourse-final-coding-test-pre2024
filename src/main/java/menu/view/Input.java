package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

public class Input {

    public static String inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public static String inputHateMenuByCoach(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coach.getName());
        return Console.readLine();
    }
}
