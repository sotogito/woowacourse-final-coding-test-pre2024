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

    public static boolean isRetry(String inputAnswer) {
        for (GameWhether answerWhether : GameWhether.values()) {
            if (answerWhether.answer.equals(inputAnswer)) {
                return answerWhether.isRetry;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 유형의 입력값입니다.");
    }

}
