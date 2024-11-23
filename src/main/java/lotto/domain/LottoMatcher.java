package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.record.LottoMatchingForm;

public class LottoMatcher {
    public List<LottoMatchingForm> match(List<Lotto> computerLottos, UserLotto userLotto) {
        List<LottoMatchingForm> result = new ArrayList<>();

        for (Lotto computerLotto : computerLottos) {
            int matchedSixLotto = userLotto.getCountMatchedSixLotto(computerLotto);
            boolean isContainBonusLotto = userLotto.isContainBonusLotto(computerLotto);

            result.add(new LottoMatchingForm(matchedSixLotto, isContainBonusLotto));
        }
        return result;
    }
}
