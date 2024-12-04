package christmas.domain.dto;

import christmas.domain.EventPlan;
import christmas.domain.user.Cart;
import christmas.domain.user.Schedule;
import christmas.domain.user.Wallet;

public record EventApplyDto(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan) {
}
