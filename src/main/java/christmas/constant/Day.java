package christmas.constant;

import java.time.DayOfWeek;

public enum Day {
    SUN(DayOfWeek.SUNDAY, false),
    MON(DayOfWeek.MONDAY, false),
    TUE(DayOfWeek.TUESDAY, false),
    WEN(DayOfWeek.WEDNESDAY, false),
    THU(DayOfWeek.THURSDAY, false),
    FRI(DayOfWeek.FRIDAY, true),
    SAT(DayOfWeek.SATURDAY, true);

    private final DayOfWeek mDayOfWeek;
    private final boolean isWeekend;

    Day(DayOfWeek dayOfWeek, boolean isWeekend) {
        mDayOfWeek = dayOfWeek;
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public static Day find(DayOfWeek dayOfWeek) {
        for (Day day : Day.values()) {
            if (day.mDayOfWeek == dayOfWeek) {
                return day;
            }
        }
        throw new IllegalArgumentException("요일 반환 오류");
    }

}
