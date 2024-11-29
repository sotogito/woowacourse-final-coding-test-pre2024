package subway.view;

import java.util.List;
import subway.constants.MainFunction;
import subway.constants.StationFunction;
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


    public static void printMainFunctionList() {
        for (MainFunction mainFunction : MainFunction.values()) {
            System.out.print(mainFunction);
        }
        System.out.println();
    }

    public static void printStationFunctionList() {
        for (StationFunction stationFunction : StationFunction.values()) {
            System.out.print(stationFunction);
        }
        System.out.println();
    }

}
