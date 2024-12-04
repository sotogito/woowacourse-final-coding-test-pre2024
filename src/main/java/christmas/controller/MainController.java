package christmas.controller;

import christmas.domain.EventPlan;
import christmas.domain.dto.OrderItemDto;
import christmas.domain.parser.OrderMenuParser;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;
import christmas.service.DiscountService;
import christmas.service.OrderService;
import christmas.view.Input;
import christmas.view.Output;
import java.util.List;

public class MainController {
    private OrderService orderService;
    private DiscountService discountService;

    public void run() {
        orderService = new OrderService();
        discountService = new DiscountService();

        Schedule schedule = createSchedule();
        Cart cart = createCart();
        Wallet wallet = orderService.calculatePurchaseAmount(cart);
        
        EventPlan eventPlanResult = discountService.applyEvent(schedule, cart, wallet);
        discountService.calculateTotalDiscountAmount(eventPlanResult, wallet);

        Output.printEventPlan(cart, wallet, eventPlanResult);

    }

    private Schedule createSchedule() {
        while (true) {
            try {
                return orderService.booking(Input.inputBookingDay());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Cart createCart() {
        while (true) {
            try {
                List<OrderItemDto> orders = OrderMenuParser.parse(Input.inputOrderMenu());
                return orderService.order(orders);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }


}
