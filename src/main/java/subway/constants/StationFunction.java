package subway.constants;

public enum StationFunction {
    ADD_STATION("1", "역 등록"),
    DELETE_STATION("2", "역 삭제"),
    PRINT_STATION("3", "역 조회"),
    BACK("B", "돌아가기");

    private final String value;
    private final String meaning;

    StationFunction(String value, String meaning) {
        this.meaning = meaning;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isBack(String input) {
        return BACK.value.equals(input);
    }

    public static StationFunction findByValue(String value) {
        for (StationFunction stationFunction : StationFunction.values()) {
            if (stationFunction.getValue().equals(value)) {
                return stationFunction;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 역 기능입니다.");
    }

}
