package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.BridgeLocation;
import bridge.constants.GameState;
import bridge.constants.GameWhether;
import bridge.domain.AttemptManager;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.OneBlock;
import java.util.List;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private boolean canMove;

    private final Bridge bridge;
    private final AttemptManager attemptManager;

    public BridgeGame(Bridge bridge, AttemptManager attemptManager) {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.canMove = true;
        this.bridge = bridge;
        this.attemptManager = attemptManager;
    }


    public void makeBridge() {
        bridge.makeBridgeBlockToSize(bridgeMaker);
    }

    public boolean isSuccess() {
        return bridge.isSameSize(attemptManager.getOrder());
    }

    public boolean canMove() {
        return canMove;
    }

    public void move(BridgeLocation inputLocation) {
        String locationValue = inputLocation.getAnswer();
        if (!bridge.canPass(locationValue, attemptManager.getOrder())) {
            canMove = false;
        }
        attemptManager.updateOrder();
    }


    public boolean retry(GameWhether inputWhether) {
        if (inputWhether.isRetry()) {
            canMove = true;
            attemptManager.updateTotalAttempts();
            attemptManager.clearOrder();
            bridge.clearBridge();
            return true;
        }
        return false;
    }

    public List<OneBlock> getNowBridge() {
        return bridge.getNowBridge(attemptManager.getOrder());
    }

    public String getGameResult() {
        GameState gameState = GameState.find(isSuccess());
        return gameState.getValue();
    }

}
