package christmas.domain.event;

import christmas.constant.DecemberEvent;
import christmas.domain.dto.EventApplyDto;
import christmas.domain.user.Schedule;

public interface Event {

    boolean isValidDate(Schedule schedule);

    //void apply(Schedule schedule, Cart cart, Wallet wallet, EventPlan eventPlan);
    void apply(EventApplyDto dto);

    DecemberEvent getEventType();

}
