package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<OneBlock> bridge;

    public Bridge() {
        bridge = new ArrayList<>();
    }

    public void addBlock(List<String> BridgeStates) {
        for (String state : BridgeStates) {
            bridge.add(new OneBlock(state));
        }
    }

    /**
     * U & 순서
     * bridge.get(index)로 OneBlock 꺼내오고
     * 일치하는지 확인
     * 만약 일치한다면 isPass true
     * 불일치한다면 isPass false
     *
     * 출력은 index까지
     * location Enum으로 넘겨서 index받고 List<List<String>>>으로
     * isPass의 상태에 따라서 업데이트하기
     */

}
