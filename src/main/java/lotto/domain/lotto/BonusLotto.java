package lotto.domain.lotto;

public class BonusLotto {
    private final int number;

    public BonusLotto(int number) {
        this.number = number;
    }

    public boolean isContain(Lotto lotto) {
        return lotto.isContains(number);
    }

    public static void validateDuplicateMainLotto(Lotto userLotto, int BonusLotto) {
        if (userLotto.isContains(BonusLotto)) {
            throw new IllegalArgumentException("보너스 로또가 6자리 로또 번호와 중복됩니다.");
        }
    }
}
