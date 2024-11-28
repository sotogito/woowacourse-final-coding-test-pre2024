package bridge.view;

import bridge.constants.BridgeLocation;
import bridge.constants.BridgeState;
import bridge.domain.AttemptManager;
import bridge.domain.bridge.OneBlock;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public void printMap(List<OneBlock> blocks, AttemptManager attemptManager) {
        List<List<String>> printoutBridge = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < blocks.size(); j++) {
                line.add(" ");
            }
            printoutBridge.add(line);
        }

        for (int i = 0; i < blocks.size(); i++) {
            OneBlock oneBlock = blocks.get(i);
            boolean isPassed = oneBlock.isPass();

            String location = oneBlock.getLocation();

            if (!isPassed && i == blocks.size() - 1) {
                location = attemptManager.getRecentLocation();
            }

            BridgeLocation locationBridge = BridgeLocation.find(location);

            int lineIndex = locationBridge.getIndex();
            String mark = BridgeState.find(isPassed).getMark();

            printoutBridge.get(lineIndex).set(i, mark);
        }

        StringBuilder result = new StringBuilder();
        for (List<String> line : printoutBridge) {
            result.append(String.format("[ %s ]", String.join(" | ", line)));
            result.append("\n");
        }
        System.out.println(result);
    }


    public void printResult(List<OneBlock> bridge, AttemptManager attemptManager, String gameResult) {
        System.out.println("최종 게임 결과");
        printMap(bridge, attemptManager);

        System.out.printf("게임 성공 여부: %s\n", gameResult);
        System.out.println(attemptManager);
    }

}
