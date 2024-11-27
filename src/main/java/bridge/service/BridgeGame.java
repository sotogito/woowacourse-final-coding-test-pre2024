package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.BridgeLocation;
import bridge.constants.GameWhether;
import bridge.domain.AttemptManager;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;

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

    public static void main(String[] args) {
        AttemptManager attemptManager = new AttemptManager();
        Bridge bridge = new Bridge(1);
        BridgeGame game = new BridgeGame(bridge, attemptManager);
        game.makeBridge();

        while (!game.isSuccess()) { //다 정답, 종료
            while (game.canMove()) { //여부 물어보기
                game.move("입력받기");
            }
            if (!game.retry("입력값")) {
                break;
            }
        }
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

    public void move(String inputLocation) {
        BridgeLocation.validateInput(inputLocation);
        if (!bridge.canPass(inputLocation, attemptManager.getOrder())) {
            canMove = false;
        }
        attemptManager.updateOrder();
    }


    public boolean retry(String inputWhether) {
        if (GameWhether.isRetry(inputWhether)) {
            canMove = false;
            attemptManager.updateTotalAttempts();
            attemptManager.clearOrder();
            bridge.clearBridge();
            return true;
        }
        return false;
    }


}
