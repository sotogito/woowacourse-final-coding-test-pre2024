package calculator.domain;

import calculator.domain.parsers.BasicParser;
import calculator.domain.parsers.CustomParser;
import calculator.domain.parsers.DelimiterParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValueMatcher {

    private final DelimiterParser baseDelimiterParser;
    private final DelimiterParser customDelimiterParser;

    public InputValueMatcher() {
        baseDelimiterParser = new BasicParser();
        customDelimiterParser = new CustomParser();
    }

    public DelimiterParser findDelimiterParser(String input) {
        Matcher customDelimiterMatcher = Pattern.compile("//(.*)\\\\n").matcher(input);
        if (customDelimiterMatcher.find()) {
            return customDelimiterParser;
        }

        return baseDelimiterParser;
    }

}
