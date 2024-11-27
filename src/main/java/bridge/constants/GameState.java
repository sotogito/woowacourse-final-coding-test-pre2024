package bridge.constants;

public enum GameState {
    SUCCESS("성공"),
    FAIL("실패");

    private String value;

    GameState(String value) {
        this.value = value;
    }

    /**
     * AttemptManager 시도 횟수가 다리 길이와 같으면 성공
     */
}
