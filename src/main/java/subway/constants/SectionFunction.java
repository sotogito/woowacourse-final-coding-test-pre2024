package subway.constants;

public enum SectionFunction {
    ADD_SECTION("1", "구간 등록"),
    DELETE_SECTION("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final String value;
    private final String meaning;

    SectionFunction(String value, String meaning) {
        this.meaning = meaning;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isBack(String input) {
        return BACK.value.equals(input);
    }

    public static SectionFunction findByValue(String value) {
        for (SectionFunction sectionFunction : SectionFunction.values()) {
            if (sectionFunction.getValue().equals(value)) {
                return sectionFunction;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 구간 기능입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s. %s\n", value, meaning);
    }
}
