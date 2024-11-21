package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.BasicDelimiter;
import calculator.domain.CalculateValue;
import java.util.List;

public class BasicParser  implements DelimiterParser {

    @Override
    public void parse(String input, CalculateValue calculateValue) {
        List<String> delimiters = BasicDelimiter.getDelimiters();
        String delimiterSplit = String.join("|", delimiters);

        String[] splitInput = input.split(delimiterSplit);


        for(String s : splitInput) {
            s = s.trim();

            if(s.isEmpty()){
                calculateValue.addNumber(0);
                continue;
            }

            int number = 0;
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("기본 구분자 외에 다른 구분자가 포함되었습니다.");
            }

            if(number < 0){
                throw new IllegalArgumentException("계산값은 양수만 가능합니다.");
            }

            calculateValue.addNumber(number);
        }

    }

    @Override
    public ParserType getParserType() {
        return ParserType.BASIC;
    }

}
