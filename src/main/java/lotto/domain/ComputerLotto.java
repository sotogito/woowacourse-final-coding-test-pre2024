package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.number.LottoMachine;
import lotto.domain.record.LottoMatchingForm;

public class ComputerLotto {
    private final List<Lotto> lottos;

    public ComputerLotto() {
        this.lottos = new ArrayList<>();
    }

    public List<LottoMatchingForm> matchLotto(LottoMatcher lottoMatcher, final UserLotto userLotto) {
        return lottoMatcher.match(lottos, userLotto);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
