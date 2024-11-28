package bridge.constants;

public enum BridgeLocation {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private final String answer;
    private final int randomNumber;
    private final int index;

    BridgeLocation(String answer, int randomNumber, int index) {
        this.answer = answer;
        this.randomNumber = randomNumber;
        this.index = index;
    }

    public String getAnswer() {
        return answer;
    }

    public int getIndex() {
        return index;
    }

    public static BridgeLocation find(String input) {
        for (BridgeLocation state : BridgeLocation.values()) {
            if (state.answer.equals(input)) {
                return state;
            }
        }
        throw new IllegalArgumentException("존재하는 위치가 없습니다.");
    }

    public static String findValueByRandomNumber(int randomNumber) {
        for (BridgeLocation bridgeLocation : BridgeLocation.values()) {
            if (bridgeLocation.randomNumber == randomNumber) {
                return bridgeLocation.answer;
            }
        }
        throw new IllegalStateException("다리 생성 오류");
    }
    

    //////////////////////////////////////////////////////////
    public int findBridgeBlockIndexByIsPass(boolean isPass) {
        if (!isPass) {
            if (this == UP) {
                return DOWN.index;
            } else if (this == DOWN) {
                return UP.index;
            }
        }
        return index;
    }

}
