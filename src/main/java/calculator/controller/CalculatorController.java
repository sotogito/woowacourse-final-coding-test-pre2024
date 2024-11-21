package calculator.controller;

import calculator.domain.CalculateValue;
import calculator.domain.InputValueMatcher;
import calculator.domain.calculator.AddCalculator;
import calculator.service.CalculateService;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController {
    private CalculateService calculateService;

    public void run() {
        calculateService = new CalculateService(
                new InputValueMatcher(),
                new CalculateValue(),
                new AddCalculator());

        parseInputValue();
        printResult();
    }

    private void parseInputValue() {
        while (true) {
            try {
                calculateService.parse(Input.inputCalculateValue());
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void printResult() {
        Output.printResult(calculateService.calculate());
    }

}
