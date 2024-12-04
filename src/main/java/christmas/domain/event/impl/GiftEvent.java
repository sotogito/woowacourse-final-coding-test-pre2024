package christmas.domain.event.impl;

import christmas.constant.Category;
import christmas.constant.DecemberEvent;
import christmas.domain.EventPlan;
import christmas.domain.dto.EventApplyDto;
import christmas.domain.event.Gift;
import christmas.domain.restaurant.MenuItem;
import christmas.domain.singleton.Restaurant;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import java.time.LocalDate;

public class GiftEvent implements Gift {
    private final static LocalDate start = LocalDate.of(2023, 12, 1);
    private final static LocalDate end = LocalDate.of(2023, 12, 31);

    private final static int APPLICABLE_AMOUNT = 120000;
    private final static Category GIFT_CATEGORY_TYPE = Category.DRINK;
    private final static String GIFT_MENU_NAME = "샴페인";
    private final static int GIFT_QUANTITY = 1;

    @Override
    public boolean isValidDate(Schedule schedule) {
        return schedule.isValidDate(start, end);
    }

    @Override
    public void apply(EventApplyDto dto) {
        Wallet wallet = dto.wallet();
        EventPlan eventPlan = dto.eventPlan();

        if (wallet.isOverAmount(APPLICABLE_AMOUNT)) {
            MenuItem menu = Restaurant.RESTAURANT.findMenuByCategoryAndMenuName(GIFT_CATEGORY_TYPE, GIFT_MENU_NAME);
            eventPlan.addGiftMenu(menu, GIFT_QUANTITY);
            eventPlan.addAppliedEvent(this, menu.getPrice());
        }
    }

    @Override
    public DecemberEvent getEventType() {
        return DecemberEvent.GIFT_EVENT;
    }

}
