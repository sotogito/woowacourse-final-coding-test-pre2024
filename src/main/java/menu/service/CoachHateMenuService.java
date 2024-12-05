package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.singleton.Restaurant;

/**
 * 코치 ㄱ개체를 생성시켜 반환하고 컨트로럴에서 for문을 돌려 각 몫먹는 음식을 저장한다.
 */
public class CoachHateMenuService {
    private final Restaurant restaurant;

    public CoachHateMenuService() {
        restaurant = Restaurant.RESTAURANT;
    }

    /**
     * 존재하는 메뉴인지 서비스에서 유효검사 못먹는 음식 개수 수*
     *
     * @param coachsName
     * @return
     */
    public Coachs createCoachs(List<String> coachsName) {
        List<Coach> coachs = new ArrayList<>();

        for (String name : coachsName) {
            coachs.add(new Coach(name));
        }
        return new Coachs(coachs);
    }

    public void updateHateMenuByCoach(Coach coach, List<String> hateMenus) {
        System.out.println(hateMenus.size());
        if (hateMenus.isEmpty()) {
            return;
        }
        for (String menuName : hateMenus) {
            restaurant.validateMenu(menuName);
        }
        coach.addHateMenus(hateMenus);
    }

}
