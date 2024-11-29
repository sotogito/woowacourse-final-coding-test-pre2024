package subway.controller.function;

import subway.constants.MainFunction;
import subway.service.SectionService;

public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public void run() {

    }

    public boolean isFunctionType(MainFunction inputFunctionType) {
        return MainFunction.SECTION_MANAGEMENT.equals(inputFunctionType)
                || MainFunction.PRINT_SUBWAY_MAP.equals(inputFunctionType);
    }

}
