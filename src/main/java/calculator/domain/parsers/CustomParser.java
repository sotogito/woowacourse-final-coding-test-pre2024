package calculator.domain.parsers;

import calculator.ParserType;
import calculator.domain.CalculateValue;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser extends DelimiterParser {
    private final static String CUSTOM_PATTERN = "//(.)\\\\n";

    private final static List<String> META_CHARACTERS = new ArrayList<>(
            List.of(".", "^", "$", "*", "+" ,"?" ,
                    "{" ,"}", "[" ,"]" ,"\\", "|", "(" ,")"));
    private final static String ESCAPE_CHARACTER = "\\";


    @Override
    public void parse(String input, CalculateValue calculateValue) {
        Pattern pattern = Pattern.compile(CUSTOM_PATTERN);
        Matcher matcher = pattern.matcher(input);
        String value = input.replaceAll(CUSTOM_PATTERN, "");
        List<String> customDelimiters = findCustomDelimiter(matcher);

        calculateValue.addAllNumber(parseIntoSplit(value, customDelimiters));

    }

    private List<String> findCustomDelimiter(Matcher matcher) {
        List<String> customDelimiters = new ArrayList<>();

        while (matcher.find()) {
            String delimiter = matcher.group(1);

            if(META_CHARACTERS.contains(delimiter)){
                delimiter = ESCAPE_CHARACTER + delimiter;
            }
            customDelimiters.add(delimiter);
        }
        validateCharacter(customDelimiters);
        validateCustomDelimiter(customDelimiters);
        return customDelimiters;
    }

    private void validateCharacter(List<String> customDelimiters) {
        if(customDelimiters.isEmpty()){
            throw new IllegalArgumentException("문자열이 아닌 문자를 입력해주세요.");
        }
    }

    private void validateCustomDelimiter(List<String> customDelimiters) {
        for(String customDelimiter : customDelimiters) {
            if (customDelimiter.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("커스텀 구분자로 숫자는 입력 불가능합니다.");
            }
        }
    }

    @Override
    public ParserType getParserType() {
        return ParserType.CUSTOM;
    }

}
