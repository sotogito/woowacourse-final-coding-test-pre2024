package christmas.domain.user;

import christmas.constant.Day;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Schedule {
    private final LocalDate date;
    private final DayOfWeek dayOfWeek;

    public Schedule(int year, int month, int dayOfMonth) {
        validateVisitDate(dayOfMonth);
        this.date = LocalDate.of(year, month, dayOfMonth);
        this.dayOfWeek = date.getDayOfWeek();
    }

    public boolean isValidDate(LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }

    public boolean isValidSpecialDate(List<Integer> days) {
        int bookingDate = date.getDayOfMonth();
        for (Integer day : days) {
            if (bookingDate == day) {
                return true;
            }
        }
        return false;
    }

    public int getChristmasDDayCount(LocalDate startDate) {
        return date.getDayOfMonth() - startDate.getDayOfMonth();
    }

    public boolean isWeekend() {
        return Day.find(dayOfWeek).isWeekend();
    }

    private void validateVisitDate(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

}
