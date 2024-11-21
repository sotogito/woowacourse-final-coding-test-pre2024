package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import calculator.ParserType;
import org.junit.jupiter.api.Test;

class InputValueMatcherTest {
    private InputValueMatcher inputValueMatcher = new InputValueMatcher();

    @Test
    void 기본_구분자_파서_반환(){
        assertEquals(
                ParserType.BASIC,
                inputValueMatcher.findDelimiterParser("1,2,3").getParserType());
    }

    @Test
    void 커스텀_구분자_파서_반환(){
        assertEquals(
                ParserType.CUSTOM,
                inputValueMatcher.findDelimiterParser("//$\n1$2$3").getParserType());
    }

}