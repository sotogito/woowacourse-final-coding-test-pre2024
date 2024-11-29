package subway.domain.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> baseStations = new ArrayList<>();
    private static final List<Station> stations = new ArrayList<>();


    public List<Station> stations() {
        List<Station> allStations = new ArrayList<>();
        allStations.addAll(baseStations);
        allStations.addAll(stations);
        allStations.sort(Station::compareTo);
        return Collections.unmodifiableList(allStations);
    }

    public void addBaseStation(Station station) {
        validateDuplicates(stations(), station);
        baseStations.add(station);
    }

    public void addStation(Station station) {
        validateDuplicates(stations(), station);
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


    public Optional<Station> findStationByName(String name) {
        for (Station station : stations()) {
            if (station.isSameName(name)) {
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }


    public void validateDuplicates(List<Station> stations, Station newStation) {
        if (stations.contains(newStation)) {
            throw new IllegalArgumentException("이미 존재하는 역입니다.");
        }
    }

}
