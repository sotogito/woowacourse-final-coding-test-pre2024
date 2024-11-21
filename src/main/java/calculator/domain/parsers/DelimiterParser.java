package calculator.domain.parsers;

import calculator.domain.CalculateValue;
import calculator.domain.constants.ParserType;
import java.util.ArrayList;
import java.util.List;

public abstract class DelimiterParser {
    private final static int SPACE_REPLACEMENT_NUMBER = 0;

    public abstract void parse(String input, CalculateValue calculateValue);

    abstract public ParserType getParserType();


    List<Integer> parseIntoSplit(String input, List<String> delimiters) {
        List<Integer> result = new ArrayList<>();
        String delimiterSplit = String.join("|", delimiters);

        for (String value : input.split(delimiterSplit)) {
            value = value.trim();

            if (checkEmpty(value, result)) {
                continue;
            }
            result.add(changeToNumber(value));
        }
        return result;
    }

    private int changeToNumber(String s) {
        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("기본 구분자 외에 다른 구분자가 포함되었습니다.");
        }

        validateNumber(number);
        return number;
    }

    private boolean checkEmpty(String value, List<Integer> result) {
        if (value.isEmpty()) {
            result.add(SPACE_REPLACEMENT_NUMBER);
            return true;
        }
        return false;
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("계산값은 양수만 가능합니다.");
        }
    }

}
