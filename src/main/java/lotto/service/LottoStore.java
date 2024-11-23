package lotto.service;

import lotto.domain.UserLotto;
import lotto.domain.Wallet;

public interface LottoStore {
    void buyLottos(Wallet wallet);

    void matchLotto(UserLotto userLotto);

    void calculateRateOfReturn(Wallet wallet);
    
}
