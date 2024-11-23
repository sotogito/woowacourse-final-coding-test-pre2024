package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoNumberParser {
    /**
     * 콤마 외 다른 문자 Input : 숫자
     */

    public List<Integer> parse(String input) {
        List<Integer> result = new ArrayList<>();

        validateNameSpecialChar(input);
        String[] splitValue = input.split(",");

        try {
            for (String s : splitValue) {
                s = s.trim();
                result.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또는 숫자로 입력해주세요.");
        }

        return result;
    }

    private void validateNameSpecialChar(String name) {
        Matcher matcher = Pattern.compile("[!@#$%^&*().?\":{}|<>]").matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("로또 번호는 콤마(,)로 구분해주세요.");
        }
    }
}
