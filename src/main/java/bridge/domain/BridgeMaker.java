package bridge.domain;

import bridge.constants.BridgeLocation;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * 나라면  List<String> makeBridge(int size); 추상메서드를 갖는 인터페이스를 만들고 BridgeMaker에 imple해서 넘겼을텐데???왜 하나하나 생성하는 인터페이스를 굳이
     * 확장성?
     */
    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            result.add(BridgeLocation.findValueByRandomNumber(randomNumber));
        }
        return result;
    }
    
}
