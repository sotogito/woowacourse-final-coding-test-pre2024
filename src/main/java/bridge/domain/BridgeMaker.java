package bridge.domain;

import bridge.constants.BridgeLocation;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            result.add(BridgeLocation.findValueByRandomNumber(randomNumber));
        }
        return result;
    }
}
