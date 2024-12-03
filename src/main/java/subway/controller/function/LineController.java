package subway.controller.function;

import subway.constants.LineFunction;
import subway.constants.MainFunction;
import subway.service.LineService;
import subway.view.Input;
import subway.view.LineInput;
import subway.view.Output;

public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    public void run() {
        while (true) {
            Output.printLineFunctionList();
            LineFunction function = inputLineFunction();
            if (function.equals(LineFunction.BACK)) {
                break;
            }
            function(function);
        }
    }

    private void function(LineFunction function) {
        if (function.equals(LineFunction.ADD_LINE)) {
            add();
        } else if (function.equals(LineFunction.DELETE_LINE)) {
            delete();
        } else if (function.equals(LineFunction.PRINT_LINE)) {
            print();
        }
    }

    private void add() {
        while (true) {
            try {
                String line = LineInput.inputAddLineName();
                String upStation = LineInput.inputUpStationName();
                String downStation = LineInput.inputDownStationName();

                lineService.addLine(line, upStation, downStation);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }


    private void delete() {
        while (true) {
            try {
                String line = LineInput.inputDeleteLineName();

                lineService.deleteLine(line);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void print() {
        Output.printLines(lineService.getAllLines());
    }


    private LineFunction inputLineFunction() {
        while (true) {
            try {
                return LineFunction.findByValue(Input.inputFunction());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }


    public boolean isFunctionType(MainFunction inputFunctionType) {
        return MainFunction.LINE_MANAGEMENT.equals(inputFunctionType);
    }

}
