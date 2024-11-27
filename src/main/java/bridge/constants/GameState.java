package bridge.constants;

public enum GameState {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private String value;
    private boolean success;

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

    /**
     * AttemptManager 시도 횟수가 다리 길이와 같으면 성공
     */
}
