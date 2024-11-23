package lotto.domain;

import java.util.EnumMap;

public enum Rank {
    FIFTH(5, 3, false, 5000, "오천"),
    FOURTH(4, 4, false, 50000, "오만"),
    THIRD(3, 5, false, 1500000, "백오십만"),
    SECOND(2, 5, true, 30000000, "삼천만"),
    FIRST(1, 6, false, 2000000000, "이십억"),
    NOTHING(-1, 0, false, 0, "영");

    private final int rank;
    private final int matchCount;
    private final boolean hasBonus;
    private final int prizeMoney;
    private final String prizeMoneyKorean;

    Rank(int rank, int matchCount, boolean hasBonus,
         int prizeMoney, String prizeMoneyKorean) {
        this.hasBonus = hasBonus;
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyKorean = prizeMoneyKorean;
    }

    public static Rank findRank(int matchCount, boolean hasBonus) {
        if (SECOND.matchCount == matchCount) {
            if (SECOND.hasBonus == hasBonus) {
                return SECOND;
            }
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NOTHING;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static EnumMap<Rank, Integer> initScores() {
        EnumMap<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Rank rank : values()) {
            map.put(rank, 0);
        }

        return map;
    }
}
