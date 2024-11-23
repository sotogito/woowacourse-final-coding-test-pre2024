package lotto.domain;

import lotto.domain.lotto.BonusLotto;
import lotto.domain.lotto.Lotto;

public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        this.bonusLotto = bonusLotto;
        this.mainLotto = mainLotto;
    }

    public static class Builder {
        private Lotto mainLotto;
        private BonusLotto bonusLotto;

        public Builder() {
        }

        public void mainLotto(Lotto mainLotto) {
            this.mainLotto = mainLotto;
        }

        public void bonusLotto(int bonusLotto) {
            BonusLotto.validateDuplicateMainLotto(mainLotto, bonusLotto);
            this.bonusLotto = new BonusLotto(bonusLotto);
        }

        public UserLotto build() {
            return new UserLotto(mainLotto, bonusLotto);
        }
    }


}
