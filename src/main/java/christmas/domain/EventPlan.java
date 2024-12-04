package christmas.domain;

import christmas.domain.event.Event;
import christmas.domain.event.Gift;
import christmas.domain.restaurant.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class EventPlan {
    private final Map<Event, Integer> eventDetails;
    private final Map<MenuItem, Integer> giftMenu;
    private Badge badge;

    public EventPlan() {
        this.eventDetails = new HashMap<>();
        this.giftMenu = new HashMap<>();
        badge = Badge.NOTHING;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public void addGiftMenu(MenuItem giftMenu, int quantity) {
        this.giftMenu.put(giftMenu, quantity);
    }

    public Map<MenuItem, Integer> getGiftMenu() {
        return giftMenu;
    }

    public void addAppliedEvent(Event event, int amount) {
        eventDetails.put(event, amount);
    }

    public int getTotalDiscountAmountWithGift() {
        int total = 0;
        for (Map.Entry<Event, Integer> entry : eventDetails.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    public int calculateDiscountAmount() {
        int total = 0;
        for (Map.Entry<Event, Integer> entry : eventDetails.entrySet()) {
            Event event = entry.getKey();
            if (event instanceof Gift) {
                continue;
            }
            total += entry.getValue();
        }
        return total;
    }

    public Badge getBadge() {
        return badge;
    }

    public Map<Event, Integer> getDiscountEvents() {
        return eventDetails;
    }


}