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

        bridgeGame.makeBridge(); //note 다시 시작해도 똑같은 다리 사용
        while (true) {
            bridgeGame.move(inputBridgeLocation()); //note 이동은 이동을 할 수 있던, 없던 동일한 상태 업데이트
            outputView.printMap(bridgeGame.getNowBridge(), attemptManager); //note 이동을 할 수 없어도 다리 출력
            if (bridgeGame.isSuccess()) { //note 가장 상위 종료 조건 - 아예 게임 종료
                break;
            }
            if (!bridgeGame.canMove()) { //note 하위 종료 조건 - 게임 재시작or종료 여부 받음
                if (!bridgeGame.retry(inputGameWhether())) {
                    break;
                }
                //note 서비스 내부에서 canMove true로 변경.
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

}
