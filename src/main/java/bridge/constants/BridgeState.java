package bridge.constants;

public enum BridgeState {
    PASS("O", true),
    FAIL("X", false);

    private final String mark;
    private final boolean isPass;

    BridgeState(String answer, boolean isPass) {
        this.mark = answer;
        this.isPass = isPass;
    }

    public String getMark() {
        return mark;
    }

    public boolean isPass() {
        return isPass;
    }


    public static BridgeState find(Boolean isPassed) {
        for (BridgeState state : BridgeState.values()) {
            if (state.isPass == isPassed) {
                return state;
            }
        }
        throw new IllegalStateException("다리 출력 오류");
    }

}
