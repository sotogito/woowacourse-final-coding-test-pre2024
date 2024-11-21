package calculator.domain.constants;

public enum ParserType {
    BASIC(null),
    CUSTOM("//(.)\\\\n");

    private final String inputForm;

    ParserType(String inputForm) {
        this.inputForm = inputForm;
    }

    public String getInputForm() {
        return inputForm;
    }

    public static String getCustomParserTypeJudge() {
        return "//(.*)\\\\n";
    }

}
