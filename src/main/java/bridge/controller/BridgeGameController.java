package bridge.controller;

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
        Bridge bridge = new Bridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge, attemptManager);

        bridgeGame.makeBridge();

        while (true) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getNowBridge()); //서비스에서
            if (bridgeGame.isSuccess()) {
                break;
            }

            if (!bridgeGame.canMove()) {
                if (!bridgeGame.retry(inputView.readGameCommand())) {
                    break;
                }
            }
        }
        outputView.printResult(attemptManager, bridgeGame.getGameResult());

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
