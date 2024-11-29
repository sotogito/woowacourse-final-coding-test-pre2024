package subway.controller;

import java.util.ArrayList;
import java.util.List;
import subway.constants.MainFunction;
import subway.controller.function.LineController;
import subway.controller.function.SectionController;
import subway.controller.function.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.SubwayLine;
import subway.domain.repo.LineRepository;
import subway.domain.repo.StationRepository;
import subway.domain.repo.SubwayLineRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.Input;
import subway.view.Output;

public class SubwayMapController {
    private final StationController stationController;
    private final LineController lineController;
    private final SectionController sectionController;

    public SubwayMapController() {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        SubwayLineRepository lineSubwayRepository = new SubwayLineRepository();

        Station gyodae = new Station("교대역");
        Station gangnam = new Station("깅님역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeCitizenSForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");

        Line line2 = new Line("2호선");
        Line line3 = new Line("3호선");
        Line shinbundangLine = new Line("신분당선");

        SubwayLine subwayLine2 = new SubwayLine(line2, new ArrayList<>(List.of(
                gyodae, gangnam, yeoksam)));
        SubwayLine subwayLine3 = new SubwayLine(line3, new ArrayList<>(List.of(
                gyodae, nambuTerminal, yangjae, maebong)));
        SubwayLine subwayLineShinbundang = new SubwayLine(shinbundangLine, new ArrayList<>(List.of(
                gangnam, yangjae, yangjaeCitizenSForest)));

        stationRepository.addStation(gyodae);
        stationRepository.addStation(gangnam);
        stationRepository.addStation(yeoksam);
        stationRepository.addStation(nambuTerminal);
        stationRepository.addStation(yangjae);
        stationRepository.addStation(yangjaeCitizenSForest);
        stationRepository.addStation(maebong);

        lineRepository.addLine(line2);
        lineRepository.addLine(line3);
        lineRepository.addLine(shinbundangLine);

        lineSubwayRepository.addSubwayLine(subwayLine2);
        lineSubwayRepository.addSubwayLine(subwayLine3);
        lineSubwayRepository.addSubwayLine(subwayLineShinbundang);

        this.lineController = new LineController(
                new LineService(lineSubwayRepository, lineRepository, stationRepository));
        this.stationController = new StationController(
                new StationService(stationRepository));
        this.sectionController = new SectionController(
                new SectionService(lineRepository, lineSubwayRepository, stationRepository));
    }

    public void run() {
        while (true) {
            MainFunction functionType = inputMainFunction();
            if (functionType.equals(MainFunction.QUIT)) {
                return;
            }
            mainFunction(functionType);
        }
    }

    private void mainFunction(MainFunction functionType) {
        if (stationController.isFunctionType(functionType)) {
            stationController.run();
        } else if (lineController.isFunctionType(functionType)) {
            lineController.run();
        } else if (sectionController.isFunctionType(functionType)) {
            sectionController.run();
        }
    }


    private MainFunction inputMainFunction() {
        while (true) {
            try {
                return MainFunction.findByValue(Input.inputFunction());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
