package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.record.LottoMatchingForm;
import org.junit.jupiter.api.Test;

class ScoreManagerTest {
    private ScoreManager scoreManager = new ScoreManager();

    @Test
    void 미당첨_결과_확인() {
        List<LottoMatchingForm> results = new ArrayList<>();
        results.add(new LottoMatchingForm(0, true));
        results.add(new LottoMatchingForm(2, false));

        scoreManager.addMatchingResult(results);
        assertTrue(scoreManager.isNothingMatched());
    }

    @Test
    void 한개_당첨_결과_최종_상금_확인() {
        List<LottoMatchingForm> results = new ArrayList<>();
        results.add(new LottoMatchingForm(6, true));

        scoreManager.addMatchingResult(results);
        assertEquals(Rank.FIRST.getPrizeMoney(), scoreManager.calculateWinningPrize());
    }

    @Test
    void 이등_당첨_결과_최종_상금_확인() {
        List<LottoMatchingForm> results = new ArrayList<>();
        results.add(new LottoMatchingForm(5, true));

        scoreManager.addMatchingResult(results);
        assertEquals(Rank.SECOND.getPrizeMoney(), scoreManager.calculateWinningPrize());
    }

    @Test
    void 삼등_당첨_결과_최종_상금_확인() {
        List<LottoMatchingForm> results = new ArrayList<>();
        results.add(new LottoMatchingForm(5, false));

        scoreManager.addMatchingResult(results);
        assertEquals(Rank.THIRD.getPrizeMoney(), scoreManager.calculateWinningPrize());
    }

    @Test
    void 동일한_랭킹_당첨_결과_최종_상금_확인() {
        List<LottoMatchingForm> results = new ArrayList<>();
        results.add(new LottoMatchingForm(3, false));
        results.add(new LottoMatchingForm(3, true));

        scoreManager.addMatchingResult(results);
        assertEquals((Rank.FIFTH.getPrizeMoney() * 2), scoreManager.calculateWinningPrize());
    }

}