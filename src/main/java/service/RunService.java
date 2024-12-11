package service;

public class RunService {
    private boolean isComplete = false;

    public boolean isCompleted() {
        return isComplete;
    }

    public void complete() {
        isComplete = true;
    }

}
