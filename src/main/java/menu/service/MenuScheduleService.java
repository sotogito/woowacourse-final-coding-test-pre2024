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
