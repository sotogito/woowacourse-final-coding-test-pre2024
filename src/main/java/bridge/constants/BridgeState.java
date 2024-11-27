package bridge.constants;

public enum BridgeState {
    PASS("O", true),
    FAIL("X", false);

    private final String answer;
    private final boolean isPass;

    BridgeState(String answer, boolean isPass) {
        this.answer = answer;
        this.isPass = isPass;
    }

    public boolean isPass() {
        return isPass;
    }

    public static BridgeState find(String answer) {
        for (BridgeState state : BridgeState.values()) {
            if (state.answer.equals(answer)) {
                return state;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 유형의 입력값입니다.");
    }

}
