package subway.view;

import java.util.List;
import subway.domain.Station;

public class Output {

    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printStations(List<Station> stations) {
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.printf("[INFO] %s\n", station.getName());
        }
    }

}
