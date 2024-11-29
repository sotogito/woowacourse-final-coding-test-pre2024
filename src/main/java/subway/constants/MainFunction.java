package subway.constants;

/**
 * 사용자가 입력하면 각자 칸트로럴에서 get해와서 비교할거임
 */
public enum MainFunction {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    PRINT_SUBWAY_MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String value;
    private final String meaning;

    MainFunction(String value, String meaning) {
        this.meaning = meaning;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MainFunction findByValue(String value) {
        for (MainFunction mainFunction : MainFunction.values()) {
            if (mainFunction.value.equals(value)) {
                return mainFunction;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 메인 기능입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s. %s\n", value, meaning);
    }

}
