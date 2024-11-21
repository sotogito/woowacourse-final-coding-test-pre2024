package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.CalculateValue;
import java.util.ArrayList;
import java.util.List;

public abstract class DelimiterParser {

     public abstract void parse(String input, CalculateValue calculateValue);
     abstract public ParserType getParserType();

    List<Integer> parseIntoSplit(String input, List<String> delimiters){
         List<Integer> result = new ArrayList<>();

         String delimiterSplit = String.join("|", delimiters);
         String[] splitInput = input.split(delimiterSplit);

         for(String s : splitInput) {
             s = s.trim();

             if(s.isEmpty()){
                 result.add(0);
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

             result.add(number);
         }
         return result;
     }
}
