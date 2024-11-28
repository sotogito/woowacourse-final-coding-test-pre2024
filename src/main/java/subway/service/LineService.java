package subway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayLine;
import subway.domain.SubwayLineRepository;

public class LineService {
    private final SubwayLineRepository subwayLineRepository;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(SubwayLineRepository subwayLineRepository, LineRepository lineRepository,
                       StationRepository stationRepository) {
        this.subwayLineRepository = subwayLineRepository;
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void addLine(String lineName, String upStationName, String downStationName) {
        Line newLine = new Line(lineName);
        lineRepository.addLine(new Line(lineName));

        Optional<Station> upStation = stationRepository.findStationByName(upStationName);
        if (upStation.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 상행역입니다. 등록부터 해주세요");

        }
        Station upFianlStation = upStation.get();

        Optional<Station> downStation = stationRepository.findStationByName(downStationName);
        if (downStation.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 하행역입니다. 등록부터 해주세요");
        }
        Station downFianlStation = downStation.get();

        subwayLineRepository.addSubwayLine(
                new SubwayLine(newLine, new ArrayList<>(List.of(upFianlStation, downFianlStation))));
    }

    public void deleteLine(String name) {
        if (!lineRepository.deleteLineByName(name)) {
            throw new IllegalArgumentException("존재하지 않는 노선입니다.");
        }
        subwayLineRepository.deleteSubwayLineByLineName(name);
    }

    public List<Line> getAllLines() {
        return lineRepository.lines();
    }

}
