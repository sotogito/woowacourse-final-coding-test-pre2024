package subway.service;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayLineRepository;

public class SectionService {
    /**
     * 순서는 1부터 ㅅ기작
     */

    private final SubwayLineRepository subwayLineRepository;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public SectionService(LineRepository lineRepository, SubwayLineRepository subwayLineRepository,
                          StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.subwayLineRepository = subwayLineRepository;
        this.stationRepository = stationRepository;
    }

    /**
     * 맴에 있는 노선이여야한다. 맵에 해당되는 삭제 순서야야한다  - 시작은 1로한다. 시작, 끝에는 추가할 수없다.
     * <p>
     * 2호선 -> 잠실역 -> 순서
     */
    public void addSection(String lineName, String stationName, int order) {
        Optional<Line> line = lineRepository.findLineByName(lineName);
        if (line.isEmpty()) {
            throw new IllegalArgumentException("아예 존재하지 않는 노선입니다.");
        }
        Line addableLine = line.get();

        Optional<Station> station = stationRepository.findStationByName(stationName);
        if (station.isEmpty()) {
            throw new IllegalArgumentException("아예 존재하지 않는 역입니다.");
        }
        Station addableStation = station.get();

        subwayLineRepository.addStationInLineAtOrder(addableLine, addableStation, order);
    }

    /**
     * 맵에 있는 노선이여야한다. 맵에 해당되는 삭제 순서야야한다  - 시작은 1로한다. 노선이 2개 이하면 제거할 수 없다.
     */
    public void deleteSection(String lineName, String stationName) {
        Optional<Line> line = lineRepository.findLineByName(lineName);
        if (line.isEmpty()) {
            throw new IllegalArgumentException("아예 존재하지 않는 노선입니다.");
        }
        Line deleteableLine = line.get();

        Optional<Station> station = stationRepository.findStationByName(stationName);
        if (station.isEmpty()) {
            throw new IllegalArgumentException("아예 존재하지 않는 역입니다.");
        }
        Station deleteableStation = station.get();

        subwayLineRepository.deleteStationInLine(deleteableLine, deleteableStation);
    }

    public TreeMap<Line, List<Station>> getSubwayMap() {
        return subwayLineRepository.getSubwayMap();
    }

}
