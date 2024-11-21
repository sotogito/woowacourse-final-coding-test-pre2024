package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.CalculateValue;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser implements DelimiterParser {
    private final static String CUSTOM_PATTERN = "//(.)\\\\n";

    private final static List<String> META_CHARACTERS = new ArrayList<>(
            List.of(".", "^", "$", "*", "+" ,"?" ,
                    "{" ,"}", "[" ,"]" ,"\\", "|", "(" ,")"));
    private final static String ESCAPE_CHARACTER = "\\";


    @Override
    public void parse(String input, CalculateValue calculateValue) {
        Pattern pattern = Pattern.compile(CUSTOM_PATTERN);
        Matcher matcher = pattern.matcher(input);


        List<String> customDelimiters = new ArrayList<>();

        while (matcher.find()) {
            String delimiter = matcher.group(1);

            if(META_CHARACTERS.contains(delimiter)){
                delimiter = ESCAPE_CHARACTER + delimiter;
            }
            customDelimiters.add(delimiter);
        }

        String delimiterSplit = String.join("|", customDelimiters);
        String value = input.replaceAll(CUSTOM_PATTERN, "");

        String[] splitInput = value.split(delimiterSplit);

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
        return ParserType.CUSTOM;
    }

}
