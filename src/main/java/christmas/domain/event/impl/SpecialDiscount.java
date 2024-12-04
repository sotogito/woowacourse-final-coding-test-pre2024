package christmas.domain.event.impl;

import christmas.constant.DecemberEvent;
import christmas.domain.EventPlan;
import christmas.domain.dto.EventApplyDto;
import christmas.domain.event.Discount;
import christmas.domain.user.Schedule;
import java.time.LocalDate;
import java.util.List;

public class SpecialDiscount implements Discount {
    private final static LocalDate start = LocalDate.of(2023, 12, 1);
    private final static LocalDate end = LocalDate.of(2023, 12, 31);
    private final static List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 31, 25);

    private final static int BASE_DISCOUNT_PRICE = 1000;

    @Override
    public boolean isValidDate(Schedule schedule) {
        return schedule.isValidDate(start, end) && schedule.isValidSpecialDate(SPECIAL_DAYS);
    }

    @Override
    public void apply(EventApplyDto dto) {
        EventPlan eventPlan = dto.eventPlan();

        eventPlan.addAppliedEvent(this, BASE_DISCOUNT_PRICE);
    }

    @Override
    public DecemberEvent getEventType() {
        return DecemberEvent.SPECIAL_DISCOUNT;
    }

}
