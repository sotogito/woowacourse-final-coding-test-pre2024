package bridge.domain.bridge;

import bridge.domain.AttemptManager;
import bridge.domain.BridgeMaker;
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

    public void makeBridgeBlockToSize(BridgeMaker bridgeMaker) {
        List<String> bridgeValue = bridgeMaker.makeBridge(size);
        for (String state : bridgeValue) {
            bridge.add(new OneBlock(state, false));
        }
    }

    public boolean tryPass(String location, AttemptManager attemptManager) {
        OneBlock nowBlock = attemptManager.findNowBridgeBlockByOrder(bridge);
        if (nowBlock.isSameLocation(location)) {
            nowBlock.setIsPass(true);
        }
        return nowBlock.isPass();
    }


    public boolean isSameSizeAndOrder(AttemptManager attemptManager) {
        return attemptManager.isSameSizeAndOrder(size);
    }

    public List<OneBlock> getNowBridge(AttemptManager attemptManager) {
        List<OneBlock> result = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (attemptManager.isSameOrder(i)) {
                break;
            }
            result.add(bridge.get(i));

        }
        return result;
    }

    public void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이 사이즈는 3~20까지만 입력가능합니다.");
        }
    }

    public void clearBridge() {
        for (OneBlock oneBlock : bridge) {
            oneBlock.clear();
        }
    }


}
