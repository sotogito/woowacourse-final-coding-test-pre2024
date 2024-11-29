package subway.domain.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.SubwayLine;

public class SubwayLineRepository {
    private final List<SubwayLine> subwayLines = new ArrayList<>();

    public void addSubwayLine(SubwayLine subwayLine) {
        subwayLines.add(subwayLine);
    }

    public void addStationInLineAtOrder(Line line, Station station, int order) {
        SubwayLine subwayLine = findSubwayLineByLine(line);
        subwayLine.addStationToLineAtOrder(station, order);
    }

    public void deleteSubwayLineByLineName(String lineName) {
        subwayLines.removeIf(subwayLine -> subwayLine.isSameLineByName(lineName));
    }

    public void deleteStationInLine(Line line, Station station) {
        SubwayLine subwayLine = findSubwayLineByLine(line);
        if (!subwayLine.isOverSize(2)) {
            throw new IllegalArgumentException("노선에 운행중인 역이 2개 이하일 때는 삭제할 수 없습니다.");
        }
        subwayLine.deleteStationInLine(station);
    }


    private SubwayLine findSubwayLineByLine(Line line) {
        for (SubwayLine subwayLine : subwayLines) {
            if (subwayLine.isSameLine(line)) {
                return subwayLine;
            }
        }
        throw new IllegalArgumentException("운행하고 있지 않은 노선입니다.");
    }

    public TreeMap<Line, List<Station>> getSubwayMap() {
        TreeMap<Line, List<Station>> result = new TreeMap<>();
        for (SubwayLine subwayLine : subwayLines) {
            subwayLine.updateSubwayMap(result);
        }
        return result;
    }

}
