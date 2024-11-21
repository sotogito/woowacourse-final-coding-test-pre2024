package calculator.domain.parsers;

import calculator.domain.CalculateValue;

public interface DelimiterParser {
    void parse(String input, CalculateValue calculateValue);
}
