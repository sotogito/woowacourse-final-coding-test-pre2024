package bridge.domain;

public class AttemptManager {
    private int totalAttempts;
    private int order;

    public AttemptManager() {
        this.totalAttempts = 0;
        this.order = 0;
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

    public int getOrder() {
        return this.order;
    }


    @Override
    public String toString() {
        return String.format("총 시도한 횟수: %d", totalAttempts + 1);
    }


}
