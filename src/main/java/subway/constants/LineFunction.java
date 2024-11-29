package subway.constants;

public enum LineFunction {
    ADD_LINE("1", "노선 등록"),
    DELETE_LINE("2", "노선 삭제"),
    PRINT_LINE("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String value;
    private final String meaning;

    LineFunction(String value, String meaning) {
        this.meaning = meaning;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isBack(String input) {
        return BACK.value.equals(input);
    }

    public static LineFunction findByValue(String value) {
        for (LineFunction lineFunction : LineFunction.values()) {
            if (lineFunction.getValue().equals(value)) {
                return lineFunction;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 노선 기능입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s. %s\n", value, meaning);
    }
}
