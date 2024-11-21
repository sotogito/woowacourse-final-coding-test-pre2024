package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.BasicDelimiter;
import calculator.domain.CalculateValue;
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
