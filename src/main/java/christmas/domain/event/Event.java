package christmas.domain.event;

import christmas.constant.DecemberEvent;
import christmas.domain.EventPlan;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;

public interface Event {
    
    boolean isValidDate(Schedule schedule);

    void apply(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan);

    DecemberEvent getEventType();

}
