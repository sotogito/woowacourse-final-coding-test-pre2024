package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.BridgeLocation;
import bridge.constants.GameState;
import bridge.constants.GameWhether;
import bridge.domain.AttemptManager;
import bridge.domain.BridgeMaker;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.OneBlock;
import java.util.List;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private boolean canMoveNow;

    private final Bridge bridge;
    private final AttemptManager attemptManager;

    public BridgeGame(Bridge bridge, AttemptManager attemptManager) {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.canMoveNow = true;
        this.bridge = bridge;
        this.attemptManager = attemptManager;
    }

    public boolean isSuccess() {
        return bridge.isSameSizeAndOrder(attemptManager) && canMoveNow;
    }

    public boolean canMove() {
        return canMoveNow;
    }


    public void makeBridge() {
        bridge.makeBridgeBlockToSize(bridgeMaker);
    }

    public void move(BridgeLocation inputLocation) {
        attemptManager.updateOrder();
        String locationValue = inputLocation.getAnswer();
        attemptManager.setRecentLocation(locationValue);
        if (!bridge.tryPass(locationValue, attemptManager)) {
            canMoveNow = false;
        }
    }

    public boolean retry(GameWhether inputWhether) {
        if (inputWhether.isRetry()) {
            canMoveNow = true;
            attemptManager.updateTotalAttempts();
            attemptManager.clearOrder();
            bridge.clearBridge();
            return true;
        }
        return false;
    }


    //note 출력 데이터
    public List<OneBlock> getNowBridge() { //bridge에서 바로 넘겨줘도 될듯
        return bridge.getNowBridge(attemptManager);
    }

    public String getGameResult() {
        GameState gameState = GameState.find(isSuccess());
        return gameState.getValue();
    }

}
