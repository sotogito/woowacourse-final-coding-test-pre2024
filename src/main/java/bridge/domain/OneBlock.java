package bridge.domain;

public class OneBlock {
    private final String location;
    private boolean isPass;

    public OneBlock(String location, boolean isPass) {
        this.location = location;
        this.isPass = isPass;
    }

    public String getLocation() {
        return location;
    }

    public boolean isPass() {
        return isPass;
    }

    public void updateState(String inputLocation) {
        if (location.equals(inputLocation)) {
            isPass = true;
        }
    }

    public void clear() {
        isPass = false;
    }

}
