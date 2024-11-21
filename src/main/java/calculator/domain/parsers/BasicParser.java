package calculator.domain.parsers;

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

            int number = Integer.parseInt(s);

            if(number < 0){
                throw new IllegalArgumentException("계산값은 양수만 가능합니다.");
            }

            calculateValue.addNumber(number);
        }

    }
}
