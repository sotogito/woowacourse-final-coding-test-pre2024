package menu.domain;

import java.util.EnumMap;
import menu.constant.Category;
import menu.constant.Week;

public class WeekMenuCategoryResult {
    private final EnumMap<Week, Category> categories;
    private final static int DUPLICATION_MIN_COUNT = 2;

    public WeekMenuCategoryResult() {
        this.categories = new EnumMap<>(Week.class);
    }

    /**
     * 하나씩 생성해야하기 때문에 내부에서 스스로 만드는것보다 서비스에서 마들어서 하나씩 넣어주는것이 더 ㅈㅎ음 1. 검증 2. 추가
     */

    //note 카테고리가 몇개 존재하는지 검증
    public boolean canAddCategory(Category category) {
        int count = 0;
        for (Week week : categories.keySet()) {
            if (category.equals(categories.get(week))) {
                count++;
            }
        }
        return count <= DUPLICATION_MIN_COUNT;
    }

    //note 추가
    public void addCategoryByWeek(Week week, Category category) {
        categories.put(week, category);
    }

}
