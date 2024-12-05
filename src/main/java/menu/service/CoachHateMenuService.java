package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coachs;

/**
 * 코치 ㄱ개체를 생성시켜 반환하고 컨트로럴에서 for문을 돌려 각 몫먹는 음식을 저장한다.
 */
public class CoachHateMenuService {

    public Coachs createCoachs(List<String> coachsName) {
        List<Coach> coachs = new ArrayList<>();

        for (String name : coachsName) {
            coachs.add(new Coach(name));
        }
        return new Coachs(coachs);
    }

    public void updateHateMenuByCoach(Coach coach, List<String> hateMenus) {
        coach.addHateMenus(hateMenus);
    }

}
