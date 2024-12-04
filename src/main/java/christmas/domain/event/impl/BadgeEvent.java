package christmas.domain.event.impl;

import christmas.constant.DecemberEvent;
import christmas.domain.Badge;
import christmas.domain.EventPlan;
import christmas.domain.event.Gift;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;

public class BadgeEvent implements Gift {

    @Override
    public boolean isValidDate(Schedule schedule) {
        return true;
    }

    @Override
    public void apply(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan) {
        Badge badge = wallet.getBadgeType();
        eventPlan.setBadge(badge);
    }

    @Override
    public DecemberEvent getEventType() {
        return null;
    }
}
