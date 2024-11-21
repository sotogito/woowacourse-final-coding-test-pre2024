package calculator.domain.parsers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.CalculateValue;
import calculator.domain.calculator.AddCalculator;
import calculator.domain.calculator.Calculator;
import org.junit.jupiter.api.Test;

class CustomParserTest {
    public DelimiterParser customParser = new CustomParser();

    @Test
    void 한개_커스텀_구분자_계산_결과_확인(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "//ㅂ\n1ㅂ2ㅂ3";

        customParser.parse(input, calculateValue);

        int expected = 6;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }

    @Test
    void 한개_이상_커스텀_구분자_계산_결과_확인(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "//ㅂ\n//ㅔ\n1ㅂ2ㅔ3";

        customParser.parse(input, calculateValue);

        int expected = 6;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }

    @Test
    void 음수_숫자_포함_예외_처리(){
        CalculateValue calculateValue = new CalculateValue();
        String input = "//ㅂ\n1ㅂ2ㅂ-3";

        assertThatThrownBy(() ->  customParser.parse(input, calculateValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메타_문자_계산_결과_확인(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "///\n1/2/3";

        customParser.parse(input, calculateValue);

        int expected = 6;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }

    @Test
    void 메타_문자_여러개_계산_결과_확인(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "///\n//*\n1*2/3";

        customParser.parse(input, calculateValue);

        int expected = 6;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }


}