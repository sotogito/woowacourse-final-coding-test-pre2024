package subway.domain;

import java.util.List;

public class SubwayLine {
    private final Line line;
    private final List<Station> stations;

    public SubwayLine(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

}
