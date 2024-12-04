package christmas.constant;

public enum PlannerPrintPolicy {
    ORDER_MENU("주문 메뉴"),
    AMOUNT_BEFORE_DISCOUNT("할인 전 총주문 금액"),
    GIFT_MENU("증정 메뉴"),
    EVENT_HISTORY("혜택 내역"),
    TOTAL_EVENT_AMOUNT("총혜택 금액"),
    AMOUNT_AFTER_DISCOUNT("할인 후 예상 결제 금액"),
    EVENT_BADGE("12월 이벤트 배지");


    private final String name;
    private final static String PRINT_FORMAT = "<%s>";

    PlannerPrintPolicy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(PRINT_FORMAT, name);
    }

}
