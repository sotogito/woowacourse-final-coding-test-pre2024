package menu.domain.parser;

import java.util.ArrayList;
import java.util.List;

public class CoachParser {

    public List<String> parse(String inputName) {
        List<String> result = new ArrayList<>();

        inputName = inputName.trim();
        if (inputName.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        String[] splitName = inputName.split(",");

        for (String s : splitName) {
            result.add(s.trim());
        }
        return result;
    }
}
