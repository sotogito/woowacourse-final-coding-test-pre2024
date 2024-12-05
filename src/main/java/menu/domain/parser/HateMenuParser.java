package menu.domain.parser;

import java.util.ArrayList;
import java.util.List;

public class HateMenuParser {

    public static List<String> parse(String inputName) {
        List<String> result = new ArrayList<>();

        inputName = inputName.trim();
        if (inputName.isEmpty()) { //fixme 이게 없으면 어떻게 사이즈가 1개이지?
            return result;
        }

        String[] splitName = inputName.split(",");

        for (String s : splitName) {
            result.add(s.trim());
        }
        return result;
    }

}
