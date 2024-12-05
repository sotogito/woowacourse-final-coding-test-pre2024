package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import menu.constant.Category;
import menu.constant.Week;
import menu.domain.singleton.Restaurant;

public class WeekMenuScheduler {
    private final EnumMap<Week, Category> categories;
    private final Coachs coachs;
    private final static int DUPLICATION_MIN_COUNT = 2;

    public WeekMenuScheduler(Coachs coachs) {
        this.categories = new EnumMap<>(Week.class);
        this.coachs = coachs;
    }

    public void schedule(List<Week> weeks, Restaurant restaurant) {
        for (Week week : weeks) {
            Category category = randomCategory();
            List<String> menusByCategory = restaurant.getMenusByCategory(category);
            for (Coach coach : coachs.getCoachs()) {
                randomCoachMenu(week, coach, menusByCategory);
            }
            addCategoryByWeek(week, category);
        }
    }

    private void randomCoachMenu(Week week, Coach coach, List<String> menusByCategory) {
        while (true) {
            String menu = Randoms.shuffle(menusByCategory).get(0); //note 서비스에서 한다면 RandomMaker
            if (!coach.isHateMenus(menu) && !coach.isContainSameMenu(menu)) {
                coach.addOneWeekMenuSchedule(week, menu);
                return;
            }
        }
    }

    private Category randomCategory() {
        while (true) {
            Category category = Category.findByNumber(Randoms.pickNumberInRange(1, 5));//note 서비스에서 한다면 RandomMaker
            if (canAddCategory(category)) {
                return category;
            }
        }
    }

    //note 카테고리가 몇개 존재하는지 검증
    private boolean canAddCategory(Category category) {
        int count = 0;
        for (Week week : categories.keySet()) {
            if (category.equals(categories.get(week))) {
                count++;
            }
        }
        return count < DUPLICATION_MIN_COUNT;
        //note 넣을 수 있냐이기 때문에, 1개일때만 가능함. <=로 할경우 2개일때 추가 가능이라 결국 3개 담김
    }

    //note 추가
    private void addCategoryByWeek(Week week, Category category) {
        categories.put(week, category);
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();
        List<String> oneWeek = new ArrayList<>();
        List<String> categoryWeek = new ArrayList<>();

        for (EnumMap.Entry<Week, Category> entry : categories.entrySet()) {
            Week week = entry.getKey();
            Category category = entry.getValue();

            oneWeek.add(week.getName());
            categoryWeek.add(category.getName());
        }

        printout.append(String.format(
                "[ 구분 | %s ]\n", String.join(" | ", oneWeek)));

        printout.append(String.format(
                "[ 카테고리 | %s ]\n", String.join(" | ", categoryWeek)));

        return printout.toString();
    }

}
