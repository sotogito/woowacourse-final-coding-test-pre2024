package lotto.controller;

import lotto.domain.ComputerLotto;
import lotto.domain.LottoNumberParser;
import lotto.domain.ScoreManager;
import lotto.domain.UserLotto;
import lotto.domain.UserLotto.Builder;
import lotto.domain.Wallet;
import lotto.service.LottoStore;
import lotto.service.LottoStoreService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private LottoStore lottoStoreService;

    public void run() {
        ComputerLotto computerLotto = new ComputerLotto();
        ScoreManager scoreManager = new ScoreManager();
        lottoStoreService = new LottoStoreService(computerLotto, scoreManager);

        Wallet wallet = createWallet();
        lottoStoreService.buyLottos(wallet);
        Output.printBoughtComputerLotto(computerLotto);

        UserLotto userLotto = createUserLotto();
        lottoStoreService.matchLotto(userLotto);
        lottoStoreService.calculateRateOfReturn(wallet);

        Output.printWinningStatistics(scoreManager);
        Output.printBoughtComputerLotto(wallet);
    }


    private UserLotto createUserLotto() {
        Builder builder = new UserLotto.Builder();
        inputUserSixLotto(builder);
        inputUserBonusLotto(builder);
        return builder.build();
    }

    private void inputUserBonusLotto(Builder builder) {
        while (true) {
            try {
                builder.bonusLotto(Input.inputBonusLotto());
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void inputUserSixLotto(Builder builder) {
        LottoNumberParser parser = new LottoNumberParser();

        while (true) {
            try {
                builder.mainLotto(parser.parse(Input.inputSixLotto()));
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Wallet createWallet() {
        while (true) {
            try {
                return new Wallet(Input.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }


}
