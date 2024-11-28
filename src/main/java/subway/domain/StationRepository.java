package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StationRepository {
    private static final List<Station> baseStations = new ArrayList<>();
    private static final List<Station> stations = new ArrayList<>();


    public List<Station> stations() {
        List<Station> result = new ArrayList<>();
        result.addAll(baseStations);
        result.addAll(stations);
        return Collections.unmodifiableList(result);
    }

    public void addBaseStation(Station station) {
        hasDuplicates(baseStations, station);
        baseStations.add(station);
    }

    public void addStation(Station station) {
        hasDuplicates(stations, station);
        stations.add(station);
    }

    public boolean isBaseStation(String name) {
        for (Station station : baseStations) {
            if (station.isSameName(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }


    public void hasDuplicates(List<Station> stations, Station newStation) {
        Set<Station> set = new HashSet<>(stations);
        if (!set.add(newStation)) {
            throw new IllegalArgumentException("이미 존재하는 역입니다.");
        }
    }

}
