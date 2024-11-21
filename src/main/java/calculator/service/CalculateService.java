package calculator.service;

import calculator.domain.CalculateValue;
import calculator.domain.InputValueMatcher;
import calculator.domain.calculator.Calculator;
import calculator.domain.parsers.DelimiterParser;

public class CalculateService {
    private final InputValueMatcher inputValueMatcher;
    private final CalculateValue calculateValue;
    private final Calculator calculator;

    public CalculateService(InputValueMatcher inputValueMatcher, CalculateValue calculateValue, Calculator calculator) {
        this.inputValueMatcher = inputValueMatcher;
        this.calculateValue = calculateValue;
        this.calculator = calculator;
    }

    public void parse(String input){
        DelimiterParser delimiterParser = inputValueMatcher.findDelimiterParser(input);
        delimiterParser.parse(input,calculateValue);
    }

    public int calculate(){
        return calculateValue.calculate(calculator);
    }

}
