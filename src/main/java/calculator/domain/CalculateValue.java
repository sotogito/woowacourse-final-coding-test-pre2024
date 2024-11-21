package calculator.domain;

import calculator.domain.calculator.Calculator;
import java.util.ArrayList;
import java.util.List;

public class CalculateValue {
    private final List<Integer> numbers;

    public CalculateValue() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }

    public int calculate(Calculator calculator) {
        return calculator.calculate(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
