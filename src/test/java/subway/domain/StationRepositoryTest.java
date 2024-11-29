package subway.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.repo.StationRepository;

class StationRepositoryTest {
    private StationRepository stationRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository();
    }


    @Test
    void 중복되는_이름_예외_처리() {
        stationRepository.addStation(new Station("강남역"));

        assertThatThrownBy(() -> stationRepository.addStation(new Station("강남역")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모든_역_출력() {
        Station station1 = new Station("강남역");
        Station station2 = new Station("평택역");
        stationRepository.addBaseStation(station1);
        stationRepository.addStation(station2);

        List<Station> actual = stationRepository.stations();
        List<Station> expected = List.of(station1, station2);

        assertEquals(actual, expected);
    }


}