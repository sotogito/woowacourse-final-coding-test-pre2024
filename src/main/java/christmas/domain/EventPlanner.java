package christmas.domain;

import christmas.domain.event.Discount;
import christmas.domain.event.Event;
import christmas.domain.event.Gift;
import christmas.domain.event.impl.BadgeEvent;
import christmas.domain.event.impl.ChristmasDDayDiscount;
import christmas.domain.event.impl.GiftEvent;
import christmas.domain.event.impl.SpecialDiscount;
import christmas.domain.event.impl.WeekdayDiscount;
import christmas.domain.event.impl.WeekendDiscount;
import christmas.domain.user.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 원래 이곳에 cart와 ㄴ촏여ㅣㄷ도 있었는데 만들기 위해 피룡한 데이터와, 만든 결과가 함께 있으면 안됨
 */
public class EventPlanner {
    private final List<Discount> events;
    private final Gift giftEvent;
    private final Gift badgeGiftEvent;

    public EventPlanner() {
        this.events = new ArrayList<>();
        giftEvent = new GiftEvent();
        badgeGiftEvent = new BadgeEvent();
        init();
    }

    //note discount만, 적용 날짜만 판단하여 반환
    public List<Event> getApplicableDateEvents(Schedule schedule) {
        List<Event> result = new ArrayList<>();

        for (Event event : events) {
            if (event.isValidDate(schedule)) {
                result.add(event);
            }
        }
        return result;
    }

    public Optional<Event> getGiftEvent(Schedule schedule) {
        if (giftEvent.isValidDate(schedule)) {
            return Optional.of(giftEvent);
        }
        return Optional.empty();
    }

    public Optional<Event> getBadgeGiftEvent(Schedule schedule) {
        if (badgeGiftEvent.isValidDate(schedule)) {
            return Optional.of(badgeGiftEvent);
        }
        return Optional.empty();
    }


    private void init() {
        Discount discount1 = new ChristmasDDayDiscount();
        Discount discount2 = new WeekdayDiscount();
        Discount discount3 = new WeekendDiscount();
        Discount discount4 = new SpecialDiscount();

        events.add(discount1);
        events.add(discount2);
        events.add(discount3);
        events.add(discount4);
    }


}
