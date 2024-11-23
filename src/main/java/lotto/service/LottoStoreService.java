package lotto.service;

import lotto.domain.ComputerLotto;
import lotto.domain.Ticket;
import lotto.domain.Wallet;
import lotto.domain.number.ComputerLottoMachine;
import lotto.domain.number.LottoMachine;

public class LottoStoreService {
    private final Ticket ticket;
    private final ComputerLotto computerLotto;
    private final LottoMachine lottoMachine;

    public LottoStoreService(ComputerLotto computerLotto, Ticket ticket) {
        this.computerLotto = computerLotto;
        this.ticket = ticket;
        this.lottoMachine = new ComputerLottoMachine();
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


}
