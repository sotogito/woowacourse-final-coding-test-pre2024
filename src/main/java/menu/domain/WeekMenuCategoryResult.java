package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
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
        return count < DUPLICATION_MIN_COUNT;
        //note 넣을 수 있냐이기 때문에, 1개일때만 가능함. <=로 할경우 2개일때 추가 가능이라 결국 3개 담김
    }

    //note 추가
    public void addCategoryByWeek(Week week, Category category) {
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
