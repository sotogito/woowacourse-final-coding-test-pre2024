package subway.domain.comparator;

import java.util.Comparator;
import subway.domain.Station;

public class StationNameComparator implements Comparator<Station> {

    @Override
    public int compare(Station o1, Station o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
