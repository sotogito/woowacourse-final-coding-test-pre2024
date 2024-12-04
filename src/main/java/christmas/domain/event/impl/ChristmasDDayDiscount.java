package christmas.domain.event.impl;

import christmas.constant.DecemberEvent;
import christmas.domain.EventPlan;
import christmas.domain.event.Discount;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import java.time.LocalDate;

public class ChristmasDDayDiscount implements Discount {
    private final static LocalDate start = LocalDate.of(2023, 12, 1);
    private final static LocalDate end = LocalDate.of(2023, 12, 25);

    private final static int BASE_DISCOUNT_PRICE = 1000;
    private final static int ADD_DISCOUNT_PRICE = 100;


    @Override
    public boolean isValidDate(Schedule schedule) {
        return schedule.isValidDate(start, end);
    }


    @Override
    public void apply(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan) {
        int totalDiscount = BASE_DISCOUNT_PRICE +
                (ADD_DISCOUNT_PRICE * schedule.getChristmasDDayCount(start));
        eventPlan.addAppliedEvent(this, totalDiscount);
    }

    @Override
    public DecemberEvent getEventType() {
        return DecemberEvent.CHRISTMAS_D_DAY_DISCOUNT;
    }

}
