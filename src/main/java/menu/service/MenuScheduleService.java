package menu.service;

import menu.constant.Week;
import menu.domain.Coachs;
import menu.domain.WeekMenuScheduler;
import menu.domain.singleton.Restaurant;

/**
 * 요일 -> 카테고리 선정 -> 각 코치의 해당 요일 메뉴 추천 과정으로 메뉴 추천 결과를 생성한다.
 */
public class MenuScheduleService {
    private final Restaurant restaurant;
    //private final Scheduler scheduler;

    public MenuScheduleService() {
        restaurant = Restaurant.RESTAURANT;
    }

    /**
     * 카테고리 결과 생앙 아예 다 만든다음에 Result에 저장?
     * <p>
     * List<Week>for문 돌리면서 카테고리 랜덤 + 유ㅛ검사 String category =categories.get(Randoms.pickNumberInRange(1, 5));
     * <p>
     * <p>
     * 코치 for문 매뉴추천 + 목먹는 음식 제외, 중복된 메뉴 제외 String menu =Randoms.shuffle(menus).get(0);
     */

    public WeekMenuScheduler schedule(Coachs coachs) {
        WeekMenuScheduler weekMenuCategoryResult = new WeekMenuScheduler(coachs);
        weekMenuCategoryResult.schedule(Week.getAllWeek(), restaurant);
        return weekMenuCategoryResult;
    }

    /*
    public WeekMenuCategoryResult schedule(Coachs coachs) {
        WeekMenuCategoryResult weekMenuCategoryResult = new WeekMenuCategoryResult(coachs);
        List<Week> weeks = Week.getAllWeek();

        for (Week week : weeks) {
            Category category = randomCategory(weekMenuCategoryResult);
            List<String> menusByCategory = restaurant.getMenusByCategory(category);
            for (Coach coach : coachs.getCoachs()) {
                randomCoachMenu(week, coach, menusByCategory);
            }
            weekMenuCategoryResult.addCategoryByWeek(week, category);
        }
        return weekMenuCategoryResult;
    }

    private void randomCoachMenu(Week week, Coach coach, List<String> menusByCategory) {
        while (true) {
            String menu = Randoms.shuffle(menusByCategory).get(0);
            if (!coach.isHateMenus(menu) && !coach.isContainSameMenu(menu)) {
                coach.addOneWeekMenuSchedule(week, menu);
                return;
            }
        }
    }

    private Category randomCategory(WeekMenuCategoryResult categoryResult) {
        while (true) {
            Category category = Category.findByNumber(Randoms.pickNumberInRange(1, 5));
            if (categoryResult.canAddCategory(category)) {
                return category;
            }
        }
    }

     */

}
