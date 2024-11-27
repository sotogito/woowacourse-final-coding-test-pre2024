package bridge.constants;

public enum BridgeState {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private String answer;
    private int randomNumber;
    private int index;

    BridgeState(String answer, int randomNumber, int index) {
        this.answer = answer;
        this.randomNumber = randomNumber;
        this.index = index;
    }

    public BridgeState find(String input) {
        for (BridgeState state : BridgeState.values()) {
            if (state.answer.equals(input)) {
                return state;
            }
        }
        throw new IllegalArgumentException("존재하는 위치가 없습니다.");
    }

}
