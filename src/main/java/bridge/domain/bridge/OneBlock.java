package bridge.domain.bridge;

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

    public void setIsPass(boolean isPass) {
        this.isPass = isPass;
    }

    public boolean isPass() {
        return isPass;
    }

    public boolean isSameLocation(String inputLocation) {
        return this.location.equals(inputLocation);
    }

    public void clear() {
        isPass = false;
    }

}
