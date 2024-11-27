package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final int size;
    private final List<OneBlock> bridge;

    public Bridge(int bridgeSize) {
        validateBridgeSize(bridgeSize);

        this.size = bridgeSize;
        bridge = new ArrayList<>();
    }

    public boolean canPass(String location, int order) {
        OneBlock nowBlock = bridge.get(order);
        nowBlock.updateState(location);
        return nowBlock.isPass();
    }

    public List<OneBlock> getNowBridge(int order) {
        List<OneBlock> result = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            result.add(bridge.get(i));
        }
        return result;
    }

    public boolean isSameSize(int attemptOrder) {
        return size == attemptOrder;
    }

    public void clearBridge() {
        for (OneBlock oneBlock : bridge) {
            oneBlock.clear();
        }
    }


    public void makeBridgeBlockToSize(BridgeMaker bridgeMaker) {
        List<String> bridgeValue = bridgeMaker.makeBridge(size);
        for (String state : bridgeValue) {
            bridge.add(new OneBlock(state, false));
        }
    }

    public void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이 사이즈는 3~20까지만 입력가능합니다.");
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
