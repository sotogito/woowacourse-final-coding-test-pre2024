package christmas.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;

class DayOfTheWeekTest {

    @Test
    void 요일_반환_확인() {
        assertEquals(Day.find(DayOfWeek.FRIDAY), Day.FRI);
    }

}