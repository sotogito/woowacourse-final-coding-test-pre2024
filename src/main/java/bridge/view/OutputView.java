package bridge.view;

import bridge.constants.BridgeLocation;
import bridge.constants.BridgeState;
import bridge.domain.AttemptManager;
import bridge.domain.OneBlock;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public void printMap(List<OneBlock> blocks) {
        List<List<String>> printoutBridge = new ArrayList<>(blocks.size());

        for (int i = 0; i < 2; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < blocks.size(); j++) {
                line.add(" ");
            }
            printoutBridge.add(line);
        }

        for (int i = 0; i < blocks.size(); i++) {
            OneBlock oneBlock = blocks.get(i);
            boolean isPasses = oneBlock.isPass();

            String location = oneBlock.getLocation();
            BridgeLocation locationBridge = BridgeLocation.find(location);

            int lineIndex = locationBridge.getIndex();
            String mark = BridgeState.find(isPasses).getMark();

            printoutBridge.get(lineIndex).set(i, mark);
        }

        StringBuilder result = new StringBuilder();
        for (List<String> line : printoutBridge) {
            result.append(String.format("[ %s ]",
                    String.join(" | ", line)));
            result.append("\n");
        }
        System.out.println(result);

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<OneBlock> bridge, AttemptManager attemptManager, String gameResult) {
        System.out.println("최종 게임 결과");
        printMap(bridge);

        System.out.printf("게임 성공 여부: %s\n", gameResult);
        System.out.println(attemptManager);

    }
}
