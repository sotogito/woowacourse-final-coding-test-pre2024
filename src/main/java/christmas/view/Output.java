package christmas.view;

import christmas.constant.PlannerPrintPolicy;
import christmas.domain.EventPlan;
import christmas.domain.event.Event;
import christmas.domain.restaurant.MenuItem;
import christmas.domain.user.Cart;
import christmas.domain.user.Wallet;
import java.util.Map;
import java.util.Map.Entry;

public class Output {
    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printEventPlan(Cart cart, Wallet wallet, EventPlan eventPlan) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        System.out.println(PlannerPrintPolicy.ORDER_MENU);
        System.out.println(cart);

        System.out.println(PlannerPrintPolicy.AMOUNT_BEFORE_DISCOUNT);
        System.out.println(wallet);

        System.out.println(PlannerPrintPolicy.GIFT_MENU);
        Map<MenuItem, Integer> giftMenu = eventPlan.getGiftMenu();
        if (giftMenu.isEmpty()) {
            System.out.println("없음");
        } else if (!giftMenu.isEmpty()) {
            for (Entry<MenuItem, Integer> entry : giftMenu.entrySet()) {
                MenuItem menuItem = entry.getKey();
                int quantity = entry.getValue();
                System.out.printf("%s : %d개\n", menuItem.getName(), quantity);
            }
        }

        System.out.println(PlannerPrintPolicy.EVENT_HISTORY);
        Map<Event, Integer> eventHistory = eventPlan.getDiscountEvents();
        if (eventHistory.isEmpty()) {
            System.out.println("없음\n");
        } else if (!eventHistory.isEmpty()) {
            for (Entry<Event, Integer> entry : eventHistory.entrySet()) {
                Event event = entry.getKey();
                int discount = entry.getValue();
                System.out.printf("%s : -%,d원\n", event.getEventType(), discount);
            }
        }

        System.out.println(PlannerPrintPolicy.TOTAL_EVENT_AMOUNT);
        int totalEventAmount = eventPlan.getTotalDiscountAmountWithGift();
        if (totalEventAmount > 0) {
            System.out.printf("-%,d원\n", totalEventAmount);
        } else if (totalEventAmount == 0) {
            System.out.println("0원\n");
        }

        System.out.println(PlannerPrintPolicy.AMOUNT_AFTER_DISCOUNT);
        System.out.printf("%,d원\n", wallet.getAmountAfterDiscount());

        System.out.println(PlannerPrintPolicy.EVENT_BADGE);
        System.out.println(eventPlan.getBadge());

    }
}
