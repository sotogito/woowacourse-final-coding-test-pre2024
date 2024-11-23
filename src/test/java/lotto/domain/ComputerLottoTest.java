package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.number.ComputerLottoMachine;
import lotto.domain.number.LottoMachine;
import org.junit.jupiter.api.Test;

class ComputerLottoTest {
    private ComputerLotto computerLotto = new ComputerLotto();

    @Test
    void 로또_생성_개수_확인() {
        LottoMachine lottoMachine = new ComputerLottoMachine();
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(2000);

        computerLotto.makeLotto(lottoMachine, ticket);

        assertEquals(2, computerLotto.lottoNumbers());
    }

}