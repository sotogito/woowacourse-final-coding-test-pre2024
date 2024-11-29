package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubwayLine {
    private final Line line;
    private final List<Station> stations;

    public SubwayLine(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public boolean isSameLineByName(String lineName) {
        return line.isSameName(lineName);
    }

    public boolean isSameLine(Line line) {
        return this.line == line;
    }

    public void addStationToLineAtOrder(Station station, int order) {
        validateStationOrderInLine(order);
        validateDuplicateStationInLine(station);
        stations.add(order, station);
    }

    public void deleteStationInLine(Station station) {
        stations.remove(station);
    }

    public boolean isOverSize(int size) {
        return stations.size() > size;
    }

    public void updateSubwayMap(Map<Line, List<Station>> subwayMap) {
        List<Station> sorted = new ArrayList<>(stations);
        sorted.sort(Station::compareTo); //note 가나다라 정렬
        //sorted.sort(new StationNameComparator());
        subwayMap.put(line, sorted);
    }

    private void validateStationOrderInLine(int order) {
        if (order < 1 || order >= stations.size()) {
            throw new IllegalArgumentException("구간 역 등록은 역과 역 사이에만 추가할 수 있습니다.");
        }
    }

    private void validateDuplicateStationInLine(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 존재하는 역입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubwayLine subwayLine = (SubwayLine) o;
        return Objects.equals(line, subwayLine.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

}
