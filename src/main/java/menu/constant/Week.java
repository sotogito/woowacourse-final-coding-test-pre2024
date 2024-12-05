package menu.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Week {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<Week, Category> initMap() {
        Map<Week, Category> result = new HashMap<>();
        for (Week week : values()) {
            result.put(week, null);
        }
        return result;
    }

    public static List<Week> getAllWeek() {
        List<Week> result = new ArrayList<>();
        for (Week week : values()) {
            result.add(week);
        }
        return result;
    }
}
