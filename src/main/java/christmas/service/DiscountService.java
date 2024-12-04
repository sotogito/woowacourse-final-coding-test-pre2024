package christmas.service;

import christmas.domain.EventPlan;
import christmas.domain.EventPlanner;
import christmas.domain.event.Event;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;

/**
 * 이벤트 찾아서 플래너에 넣어주면 생성해줌
 */
public class DiscountService {
    private final EventPlanner eventPlanner;

    public DiscountService() {
        this.eventPlanner = new EventPlanner();
    }

    public EventPlan applyEvent(Schedule schedule, Cart cart, Wallet wallet) {
        EventPlan eventPlan = new EventPlan();
        for (Event event : eventPlanner.getApplicableDateEvents(schedule)) {
            event.apply(schedule, cart, wallet, eventPlan);
        }
        return eventPlan;
    }

    public void calculateTotalDiscountAmount(EventPlan eventPlan, Wallet wallet) {
        wallet.setTotalDiscountAmount(eventPlan.calculateDiscountAmount());
    }

}
