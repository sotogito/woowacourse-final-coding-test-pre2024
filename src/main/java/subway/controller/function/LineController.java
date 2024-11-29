package subway.controller.function;

import subway.constants.MainFunction;
import subway.service.LineService;

public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    public void run() {
        while (true) {
            /**
             * 만약 B 누르면 break
             */
        }
    }

    public boolean isFunctionType(MainFunction inputFunctionType) {
        return MainFunction.LINE_MANAGEMENT.equals(inputFunctionType);
    }
}
