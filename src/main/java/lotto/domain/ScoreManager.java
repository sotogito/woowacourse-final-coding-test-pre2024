package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.record.LottoMatchingForm;

public class ScoreManager {
    private final EnumMap<Rank, Integer> scores;

    public ScoreManager() {
        scores = Rank.initScores();

    }

    public boolean isNothingMatched() {
        return scores.get(Rank.NOTHING) == 1;
    }

    public void addMatchingResult(List<LottoMatchingForm> results) {
        int nothingCount = 0;
        for (LottoMatchingForm result : results) {
            int sixLotto = result.sixLotto();
            boolean bonusLotto = result.isBonus();
            Rank rank = Rank.findRank(sixLotto, bonusLotto);

            if (rank.equals(Rank.NOTHING)) {
                nothingCount++;
                continue;
            }
            scores.merge(rank, 1, Integer::sum);
        }
        if (nothingCount == results.size()) {
            scores.put(Rank.NOTHING, 1);
        }
    }

    public int calculateWinningPrize() {
        int result = 0;
        for (Map.Entry<Rank, Integer> entry : scores.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            result += (count * rank.getPrizeMoney());
        }
        return result;
    }

    public EnumMap<Rank, Integer> getScores() {
        return scores;
    }


}
