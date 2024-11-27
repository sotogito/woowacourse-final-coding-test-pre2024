package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void makeBridge() {

    }

    public void move() {
    }

    public void retry() {
    }

}
