package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class ComputerLotto {
    private final List<Lotto> lottos;

    public ComputerLotto() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }


}
