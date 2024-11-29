package subway.controller.function;

import subway.constants.MainFunction;
import subway.constants.SectionFunction;
import subway.service.SectionService;
import subway.view.Input;
import subway.view.Output;
import subway.view.SectionInput;

public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public void run(MainFunction mainFunction) {
        if (mainFunction.equals(MainFunction.PRINT_SUBWAY_MAP)) {
            printAllSubwayMap();
            return;
        }
        while (true) {
            Output.printSectionFunctionList();
            SectionFunction function = inputLineFunction();
            if (function.equals(SectionFunction.BACK)) {
                break;
            }
            if (function.equals(SectionFunction.ADD_SECTION)) {
                add();
            } else if (function.equals(SectionFunction.DELETE_SECTION)) {
                delete();
            }
        }


    }

    public void add() {
        while (true) {
            try {
                String line = SectionInput.inputAddLineNameInSection();
                String station = SectionInput.inputAddStationNameInSection();
                int order = SectionInput.inputAddOrderInSection();

                sectionService.addSection(line, station, order);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    public void delete() {
        while (true) {
            try {
                String line = SectionInput.inputDeleteLineNameInSection();
                String station = SectionInput.inputDeleteStationNameInSection();

                sectionService.deleteSection(line, station);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }


    public void printAllSubwayMap() {
        Output.printAllSubwayMap(sectionService.getSubwayMap());
    }

    private SectionFunction inputLineFunction() {
        while (true) {
            try {
                return SectionFunction.findByValue(Input.inputFunction());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    public boolean isFunctionType(MainFunction inputFunctionType) {
        return MainFunction.SECTION_MANAGEMENT.equals(inputFunctionType)
                || MainFunction.PRINT_SUBWAY_MAP.equals(inputFunctionType);
    }


}
