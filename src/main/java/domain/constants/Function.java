package domain.constants;

public enum Function {
    ADD_ORDER(1),
    PAYMENT(2),
    QUIT(3);
    private final int value;

    Function(int value) {
        this.value = value;
    }

    public static Function find(int value) {
        for (Function func : values()) {

            if (func.value == value) {
                return func;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 기능입니다.");
    }
}
