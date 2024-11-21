package calculator.domain.parsers;

import calculator.domain.CalculateValue;
import calculator.domain.constants.BasicDelimiter;
import calculator.domain.constants.ParserType;
import java.util.List;

public class BasicParser extends DelimiterParser {

    @Override
    public void parse(String input, CalculateValue calculateValue) {
        List<String> delimiters = BasicDelimiter.getAll();
        calculateValue.addAllNumber(parseIntoSplit(input, delimiters));
    }

    @Override
    public ParserType getParserType() {
        return ParserType.BASIC;
    }

}
