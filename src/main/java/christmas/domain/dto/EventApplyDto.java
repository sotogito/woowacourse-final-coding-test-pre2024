package christmas.domain.dto;

import christmas.domain.EventPlan;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;

public record EventApplyDto(Schedule schedule, Cart cart, EventPlan eventPlan) {
}
