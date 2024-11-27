package bridge.constants;

public enum GameWhether {
    RETRY("R", true),
    QUIT("Q", false);

    private final String answer;
    private final boolean isRetry;

    GameWhether(String answer, boolean isRetry) {
        this.answer = answer;
        this.isRetry = isRetry;
    }

    public boolean isRetry() {
        return isRetry;
    }


    public static GameWhether find(String String) {
        for (GameWhether gameWhether : GameWhether.values()) {
            if (gameWhether.answer.equals(String)) {
                return gameWhether;
            }
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

}
