package menu.domain;

import java.util.List;

public class Coachs {
    private final List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
        this.coachs = coachs;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

}
