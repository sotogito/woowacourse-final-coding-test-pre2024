package calculator.domain.parsers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.CalculateValue;
import calculator.domain.calculator.AddCalculator;
import calculator.domain.calculator.Calculator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BasicParserTest {
    public DelimiterParser basicParser = new BasicParser();

    @Test
    void 기본_구분자_파싱_결과_확인(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "1,2:3";

        basicParser.parse(input, calculateValue);

        int expected = 6;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }

    @Test
    void 음수_숫자_포함_예외_처리(){
        CalculateValue calculateValue = new CalculateValue();
        String input = "1,2: -3";

        assertThatThrownBy(() ->  basicParser.parse(input, calculateValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_0으로_처리(){
        CalculateValue calculateValue = new CalculateValue();
        Calculator calculator = new AddCalculator();
        String input = "1,:3";

        basicParser.parse(input, calculateValue);

        int expected = 4;
        int actual = calculateValue.calculate(calculator);

        assertEquals(expected, actual);
    }

}