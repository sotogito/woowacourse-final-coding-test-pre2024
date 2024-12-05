package christmas.service;

import christmas.domain.EventPlan;
import christmas.domain.EventPlanner;
import christmas.domain.dto.EventApplyDto;
import christmas.domain.event.Event;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import java.util.Optional;

/**
 * 이벤트 찾아서 플래너에 넣어주면 생성해줌
 */
public class DiscountService {
    private final EventPlanner eventPlanner;

    public DiscountService() {
        this.eventPlanner = new EventPlanner();
    }

    /**
     * EventPlan 내부에서 하기에는 책임 이 너무 크고 로직이 무겁다.
     */
    public EventPlan applyEvent(Schedule schedule, Cart cart, Wallet wallet) {
        EventPlan eventPlan = new EventPlan(schedule, cart, wallet);
        EventApplyDto dto = new EventApplyDto(schedule, cart, wallet, eventPlan);

        if (!wallet.canEvent()) {
            return eventPlan;
        }

        for (Event event : eventPlanner.getApplicableDateEvents(schedule)) {
            event.apply(dto);
        }

        Optional<Event> giftEvent = eventPlanner.getGiftEvent(schedule);
        if (giftEvent.isPresent()) {
            Event gift = giftEvent.get();
            gift.apply(dto);
        }

        Optional<Event> badgeGiftEvent = eventPlanner.getBadgeGiftEvent(schedule);
        if (badgeGiftEvent.isPresent()) {
            Event badge = badgeGiftEvent.get();
            badge.apply(dto);
        }

        return eventPlan;
    }

    public void calculateTotalDiscountAmount(EventPlan eventPlan, Wallet wallet) {
        wallet.setTotalDiscountAmount(eventPlan.calculateDiscountAmount());
    }

}
