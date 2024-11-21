package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.CalculateValue;

public interface DelimiterParser {
    void parse(String input, CalculateValue calculateValue);

    ParserType getParserType();
}
