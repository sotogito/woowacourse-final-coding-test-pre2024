package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coachs {
    private final List<Coach> coachs;

    public Coachs(List<Coach> coachs) {
        validateDuplicate(coachs);
        validateCoachCount(coachs);
        this.coachs = coachs;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }


    public void validateDuplicate(List<Coach> coaches) {
        Set<Coach> carSet = new HashSet<>();
        for (Coach co : coaches) {
            if (!carSet.add(co)) {
                throw new IllegalArgumentException("중복된 코치 이름이 존재합니다.");
            }
        }
    }

    public void validateCoachCount(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 2~5명으로 입력해주세요.");
        }
    }

}
