package christmas.domain.event.impl;

import christmas.constant.Category;
import christmas.constant.DecemberEvent;
import christmas.domain.EventPlan;
import christmas.domain.dto.CategoryQuantityDto;
import christmas.domain.event.Discount;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import java.time.LocalDate;

public class WeekdayDiscount implements Discount {
    private final static LocalDate start = LocalDate.of(2023, 12, 1);
    private final static LocalDate end = LocalDate.of(2023, 12, 31);

    private final static int BASE_DISCOUNT_PRICE = 2023;
    private final static Category APPLY_CATEGORY = Category.DESSERT;

    @Override
    public boolean isValidDate(Schedule schedule) {
        return schedule.isValidDate(start, end) && !schedule.isWeekend();
    }

    @Override
    public void apply(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan) {
        CategoryQuantityDto dto = cart.findQuantityByCategory(APPLY_CATEGORY);
        int totalDiscount = BASE_DISCOUNT_PRICE * dto.quantity();
        eventPlan.addAppliedEvent(this, totalDiscount);
    }

    @Override
    public DecemberEvent getEventType() {
        return DecemberEvent.WEEKDAY_DISCOUNT;
    }

}
