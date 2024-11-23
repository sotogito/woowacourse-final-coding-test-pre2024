package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicates(numbers);
        //Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    public int getCountMatchedSixLotto(final Lotto otherLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (otherLotto.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("로또 번호는 1~45까지 압력해주세요.");
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복되지 않은 로또 번호를 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        List<Integer> printout = new ArrayList<>(numbers);
        Collections.sort(printout);

        return printout.toString();
    }
}
