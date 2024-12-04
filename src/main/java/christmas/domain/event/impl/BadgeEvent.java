package christmas.domain.event.impl;

import christmas.constant.DecemberEvent;
import christmas.domain.Badge;
import christmas.domain.EventPlan;
import christmas.domain.dto.EventApplyDto;
import christmas.domain.event.Gift;
import christmas.domain.user.Schedule;

public class BadgeEvent implements Gift {

    @Override
    public boolean isValidDate(Schedule schedule) {
        return true;
    }

    @Override
    public void apply(EventApplyDto dto) {
        EventPlan eventPlan = dto.eventPlan();

        Badge badge = Badge.findByDiscountAmount(eventPlan.getTotalDiscountAmountWithGift());
        eventPlan.setBadge(badge);
    }

    @Override
    public DecemberEvent getEventType() {
        return DecemberEvent.BADGE_EVENT;
    }

}
