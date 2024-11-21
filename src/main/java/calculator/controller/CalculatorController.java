package calculator.controller;

import calculator.domain.CalculateValue;
import calculator.domain.InputValueMatcher;
import calculator.domain.calculator.AddCalculator;
import calculator.service.CalculateService;
import calculator.view.Input;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private CalculateService calculateService;

    public void run(){
        calculateService = new CalculateService(
                new InputValueMatcher(),
                new CalculateValue(),
                new AddCalculator());

        parseInputValue();

        printResult();
    }

    private void printResult() {
        System.out.println(calculateService.calculate());
    }

    private void parseInputValue(){
        while(true){
            try{
                calculateService.parse(Input.inputCalculateValue());
                return;
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }


}
