package lotto.domain;

import java.util.List;
import lotto.domain.lotto.BonusLotto;
import lotto.domain.lotto.Lotto;

public class UserLotto {
    private final Lotto mainLotto;
    private final BonusLotto bonusLotto;

    public UserLotto(Lotto mainLotto, BonusLotto bonusLotto) {
        this.bonusLotto = bonusLotto;
        this.mainLotto = mainLotto;
    }

    public int getCountMatchedSixLotto(final Lotto computerLotto) {
        return mainLotto.getCountMatchedSixLotto(computerLotto);
    }

    public boolean isContainBonusLotto(final Lotto computerLotto) {
        return bonusLotto.isContain(computerLotto);
    }


    public static class Builder {
        private Lotto mainLotto;
        private BonusLotto bonusLotto;

        public Builder() {
        }

        public void mainLotto(List<Integer> mainLottoNumbers) {
            this.mainLotto = new Lotto(mainLottoNumbers);
        }

        public void bonusLotto(int bonusLottoNumber) {
            BonusLotto.validateDuplicateMainLotto(mainLotto, bonusLottoNumber);
            this.bonusLotto = new BonusLotto(bonusLottoNumber);
        }

        public UserLotto build() {
            return new UserLotto(mainLotto, bonusLotto);
        }
    }


}
