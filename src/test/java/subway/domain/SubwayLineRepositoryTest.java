package subway.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import subway.domain.repo.SubwayLineRepository;

class SubwayLineRepositoryTest {
    private SubwayLineRepository subwayLineRepository = new SubwayLineRepository();

    @Test
    void TreeMap_정렬_확인() {
        subwayLineRepository.addSubwayLine(new SubwayLine(new Line("가나다"),
                new ArrayList<>(List.of(new Station("c123"), new Station("b456")))));
        subwayLineRepository.addSubwayLine(new SubwayLine(new Line("123"),
                new ArrayList<>(List.of(new Station("a345"), new Station("b4few6")))));
        subwayLineRepository.addSubwayLine(new SubwayLine(new Line("fsf"),
                new ArrayList<>(List.of(new Station("a856"), new Station("다6")))));

        TreeMap<Line, List<Station>> actual = subwayLineRepository.getSubwayMap();

        for (Map.Entry<Line, List<Station>> entry : actual.entrySet()) {
            System.out.println(entry.getKey());
            for (Station station : entry.getValue()) {
                System.out.println(station.getName());
            }
        }
        Line firstLine = actual.keySet().iterator().next();
        assertEquals(firstLine.getName(), "123");
    }

}