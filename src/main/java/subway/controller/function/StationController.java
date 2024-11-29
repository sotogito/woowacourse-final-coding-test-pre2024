package subway.controller.function;

import subway.constants.MainFunction;
import subway.constants.StationFunction;
import subway.service.StationService;
import subway.view.Input;
import subway.view.Output;
import subway.view.StationInput;

public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    public void run() {
        while (true) {
            Output.printStationFunctionList();
            StationFunction function = inputStationFunction();
            if (function.equals(StationFunction.BACK)) {
                break;
            }
            if (function.equals(StationFunction.ADD_STATION)) {
                add();
            } else if (function.equals(StationFunction.DELETE_STATION)) {
                delete();
            } else if (function.equals(StationFunction.PRINT_STATION)) {
                print();
            }
        }
    }

    private void add() {
        while (true) {
            try {
                String input = StationInput.inputStationName();
                if (StationFunction.isBack(input)) { //note 만약 B를 누를경우 역 기능 화면으로 돌아감
                    return;
                }
                stationService.addStation(input);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void delete() {
        while (true) {
            try {
                String input = StationInput.inputDeleteStationName();
                if (StationFunction.isBack(input)) {
                    return;
                }
                stationService.deleteStation(input);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void print() {
        Output.printStations(stationService.getAllStations());
    }


    private StationFunction inputStationFunction() {
        while (true) {
            try {
                return StationFunction.findByValue(Input.inputFunction());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    public boolean isFunctionType(MainFunction inputFunctionType) {
        return MainFunction.STATION_MANAGEMENT.equals(inputFunctionType);
    }

}
