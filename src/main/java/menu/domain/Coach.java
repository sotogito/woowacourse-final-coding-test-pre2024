package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import menu.constant.Week;

public class Coach {
    private final String name;
    private final List<String> hateMenu;
    private final EnumMap<Week, String> OneWeekMenuSchedule;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.hateMenu = new ArrayList<>();
        OneWeekMenuSchedule = new EnumMap<>(Week.class);
    }

    public void addHateMenu(String menu) {
        hateMenu.add(menu);
    }
    
    public void addOneWeekMenuSchedule(Week week, String menu) {
        OneWeekMenuSchedule.put(week, menu);
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("이름은 2~4글자로 입력해주세요.");
        }
    }

}
