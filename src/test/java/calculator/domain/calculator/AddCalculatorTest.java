package calculator.domain.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AddCalculatorTest {

    @Test
    void 덤셈_계산_결과_확인(){
        Calculator calculator = new AddCalculator();
        List<Integer> numbers = new ArrayList<>(List.of(1,2));

        assertEquals(3,calculator.calculate(numbers));
    }

}