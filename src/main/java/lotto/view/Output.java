package lotto.view;

import java.util.Map;
import lotto.domain.ComputerLotto;
import lotto.domain.Rank;
import lotto.domain.ScoreManager;
import lotto.domain.Wallet;

public class Output {
    public static void printError(String error) {
        System.out.printf("[ERROR] %s\n", error);
    }

    public static void printBoughtComputerLotto(ComputerLotto computerLotto) {
        System.out.printf("%d개를 구매했습니다.\n", computerLotto.lottoNumbers());
        System.out.println(computerLotto);
    }

    public static void printWinningStatistics(ScoreManager scoreManager) {
        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder printout = new StringBuilder();
        for (Map.Entry<Rank, Integer> score : scoreManager.getScores().entrySet()) {
            Rank rank = score.getKey();
            int count = score.getValue();

            if (rank.equals(Rank.NOTHING)) {
                continue;
            }

            if (rank.equals(Rank.SECOND)) {
                printout.append(
                        String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                                rank.getMatchCount(),
                                rank.getPrizeMoney(),
                                count));
                continue;
            }
            printout.append(
                    String.format("%d개 일치 (%,d원) - %d개\n",
                            rank.getMatchCount(),
                            rank.getPrizeMoney(),
                            count));

        }
        System.out.println(printout);
    }


    public static void printBoughtComputerLotto(Wallet wallet) {
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", wallet.getRateOfReturn());
    }

}
