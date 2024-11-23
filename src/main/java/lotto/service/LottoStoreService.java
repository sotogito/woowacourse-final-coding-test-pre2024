package lotto.service;

import java.util.List;
import lotto.domain.ComputerLotto;
import lotto.domain.LottoMatcher;
import lotto.domain.RateOfReturnCalculator;
import lotto.domain.ScoreManager;
import lotto.domain.Ticket;
import lotto.domain.UserLotto;
import lotto.domain.Wallet;
import lotto.domain.number.ComputerLottoMachine;
import lotto.domain.number.LottoMachine;
import lotto.domain.record.LottoMatchingForm;

public class LottoStoreService {
    private final Ticket ticket;
    private final ComputerLotto computerLotto;
    private final LottoMachine lottoMachine;
    private final LottoMatcher lottoMatcher;
    private final ScoreManager scoreManager;
    private final RateOfReturnCalculator rateOfReturnCalculator;

    public LottoStoreService(ComputerLotto computerLotto, Ticket ticket) {
        this.computerLotto = computerLotto;
        this.ticket = ticket;
        this.lottoMachine = new ComputerLottoMachine();
        this.lottoMatcher = new LottoMatcher();
        this.scoreManager = new ScoreManager();
        this.rateOfReturnCalculator = new RateOfReturnCalculator();
    }

    public void buyLottos(Wallet wallet) {
        buyTicket(wallet);
        makeRandomLottos();
    }

    private void makeRandomLottos() {
        computerLotto.makeLotto(lottoMachine, ticket);
    }

    private void buyTicket(Wallet wallet) {
        wallet.calculateTicket(ticket);
    }


    public void matchLotto(UserLotto userLotto) {
        List<LottoMatchingForm> matchingResult = computerLotto.matchLotto(lottoMatcher, userLotto);
        scoreManager.addMatchingResult(matchingResult);
    }


    public void calculateRateOfReturn(Wallet wallet) {
        int totalWinningPrize = scoreManager.calculateWinningPrize();
        wallet.calculateTicket(ticket);
    }


}
