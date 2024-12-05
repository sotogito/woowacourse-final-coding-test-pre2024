package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import menu.constant.Week;
import menu.domain.singleton.Restaurant;

public class Coach {
    private final String name;
    private final List<String> hateMenu;
    private final EnumMap<Week, String> OneWeekMenuSchedule; //note 얘는 왜 코치에서 저장해도되지

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.hateMenu = new ArrayList<>();
        OneWeekMenuSchedule = new EnumMap<>(Week.class);
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(String hateMenuName) {
        Restaurant.RESTAURANT.validateMenu(hateMenuName);
        this.hateMenu.add(hateMenuName);
    }

    public boolean isHateMenus(String menu) {
        return hateMenu.contains(menu);
    }

    public boolean isContainSameMenu(String menu) {
        for (EnumMap.Entry<Week, String> entry : OneWeekMenuSchedule.entrySet()) {
            if (menu.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public void addOneWeekMenuSchedule(Week week, String menu) {
        OneWeekMenuSchedule.put(week, menu);
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("이름은 2~4글자로 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        List<String> menuResult = new ArrayList<>();
        for (EnumMap.Entry<Week, String> entry : OneWeekMenuSchedule.entrySet()) {
            menuResult.add(entry.getValue());
        }

        return String.format(
                "[ %s | %s ]\n", name, String.join(" | ", menuResult));
    }

}
