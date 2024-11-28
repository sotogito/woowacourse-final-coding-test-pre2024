package bridge.constants;

public enum GameState {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String value;
    private final boolean success;

    GameState(String value, boolean success) {
        this.value = value;
        this.success = success;
    }

    public String getValue() {
        return value;
    }

    public static GameState find(boolean isSuccess) {
        for (GameState gameState : GameState.values()) {
            if (gameState.success == isSuccess) {
                return gameState;
            }
        }
        throw new IllegalStateException("게임 결과 출력 오류");
    }

}
