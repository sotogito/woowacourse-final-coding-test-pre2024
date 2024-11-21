package calculator.domain.calculator;

import java.util.List;

public class AddCalculator implements Calculator {

    @Override
    public int calculate(List<Integer> numbers) {
        return numbers.stream().mapToInt(n -> n).sum();
    }

}
