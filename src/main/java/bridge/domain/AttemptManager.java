package bridge.domain;

import bridge.domain.bridge.OneBlock;
import java.util.List;

public class AttemptManager {
    private int totalAttempts;
    private int order;
    private String recentLocation;

    public AttemptManager() {
        this.totalAttempts = 0;
        this.order = 0;
        this.recentLocation = "";
    }

    public void updateOrder() {
        this.order += 1;
    }

    public void updateTotalAttempts() {
        this.totalAttempts += 1;
    }


    public boolean isSameSizeAndOrder(int bridgeSize) {
        return order == bridgeSize;
    }

    public boolean isSameOrder(int otherOrder) {
        return this.order == otherOrder;
    }


    public OneBlock findNowBridgeBlockByOrder(List<OneBlock> oneBlocks) {
        return oneBlocks.get(order - 1);
    }

    public void setRecentLocation(String recentLocation) {
        this.recentLocation = recentLocation;
    }

    public String getRecentLocation() {
        return recentLocation;
    }

    public void clearOrder() {
        this.order = 0;
    }

    @Override
    public String toString() {
        return String.format("총 시도한 횟수: %d", totalAttempts + 1);
    }

}
