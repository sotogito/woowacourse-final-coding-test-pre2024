package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Schedule {
    private final LocalDate date;
    private final DayOfWeek dayOfWeek;

    public Schedule(int year, int month, int dayOfMonth) {
        validateVisitDate(dayOfMonth);
        this.date = LocalDate.of(year, month, dayOfMonth);
        this.dayOfWeek = date.getDayOfWeek();
    }

    private void validateVisitDate(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException("방문 날짜는 1~31까지 가능합니다.");
        }
    }

}
