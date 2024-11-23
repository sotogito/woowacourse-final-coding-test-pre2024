package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ComputerLottoMachine implements LottoMachine {
    @Override
    public List<Integer> make() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
