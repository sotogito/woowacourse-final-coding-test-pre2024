package bridge.controller;

import bridge.constants.BridgeLocation;
import bridge.constants.GameWhether;
import bridge.domain.AttemptManager;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        AttemptManager attemptManager = new AttemptManager();
        Bridge bridge = createBridge();
        bridgeGame = new BridgeGame(bridge, attemptManager);

        bridgeGame.makeBridge();

        //Enum으로 받아야 유효검사함
        while (true) {
            bridgeGame.move(inputBridgeLocation());
            outputView.printMap(bridgeGame.getNowBridge()); //서비스에서
            if (bridgeGame.isSuccess()) {
                break;
            }

            if (!bridgeGame.canMove()) {
                if (!bridgeGame.retry(inputGameWhether())) {
                    break;
                }
            }
        }

        outputView.printResult(bridgeGame.getNowBridge(), attemptManager, bridgeGame.getGameResult());

    }

    private GameWhether inputGameWhether() {
        while (true) {
            try {
                return GameWhether.find(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private BridgeLocation inputBridgeLocation() {
        while (true) {
            try {
                return BridgeLocation.find(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Bridge createBridge() {
        while (true) {
            try {
                return new Bridge(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    /*
     *
while (!bridgeGame.isSuccess()) { //다 정답, 종료
            while (bridgeGame.canMove()) { //여부 물어보기
                bridgeGame.move(inputView.readMoving());

            }

            if (!bridgeGame.retry(inputView.readGameCommand())) {
                break;
            }

        }
     */
}
