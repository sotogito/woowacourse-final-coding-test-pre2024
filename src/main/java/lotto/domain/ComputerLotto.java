package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.number.LottoMachine;

public class ComputerLotto {
    private final List<Lotto> lottos;

    public ComputerLotto() {
        this.lottos = new ArrayList<>();
    }

    public void makeLotto(LottoMachine lottoMachine, Ticket ticket) {
        while (!ticket.isEnd()) {
            lottos.add(new Lotto(lottoMachine.make()));
            ticket.useTicket();
        }
    }

    public int lottoNumbers() {
        return lottos.size();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }


}
