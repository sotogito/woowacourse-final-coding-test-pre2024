package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {
    private final StationRepository stationRepository;

    public StationService() {
        this.stationRepository = new StationRepository();
    }

    public void addStation(String name) {
        stationRepository.addStation(new Station(name));
    }

    public void deleteStation(String name) {
        if (stationRepository.isBaseStation(name)) {
            throw new IllegalArgumentException("기본 역은 삭제할 수 없습니다.");
        } else if (!stationRepository.deleteStation(name)) {
            throw new IllegalArgumentException("존재하지 않는 역입니다.");
        }
    }

    public List<Station> getAllStations() {
        return stationRepository.stations();
    }

}
