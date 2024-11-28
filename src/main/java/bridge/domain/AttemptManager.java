package bridge.domain;

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

    public void setRecentLocation(String recentLocation) {
        this.recentLocation = recentLocation;
    }

    public void updateTotalAttempts() {
        this.totalAttempts += 1;
    }

    public void updateOrder() {
        this.order += 1;
    }

    public void clearOrder() {
        this.order = 0;
    }

    public boolean isSameOrder(int otherOrder) {
        return this.order == otherOrder;
    }

    public boolean isSameSizeAndOrder(int bridgeSize) {
        return order == bridgeSize;
    }

    public OneBlock findNowBridgeBlockByOrder(List<OneBlock> oneBlocks) {
        return oneBlocks.get(order - 1);
    }

    public String getRecentLocation() {
        return recentLocation;
    }

    @Override
    public String toString() {
        return String.format("총 시도한 횟수: %d", totalAttempts + 1);
    }


}
