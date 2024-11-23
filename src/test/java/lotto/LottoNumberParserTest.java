package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberParserTest {
    private LottoNumberParser lottoNumberParser = new LottoNumberParser();

    @Test
    void 파싱_결과_확인() {
        List<Integer> expect = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> actual = lottoNumberParser.parse("1,2,3,4,5   ,6");

        assertEquals(expect, actual);
    }


    @Test
    void 특수문자_예외_처리() {
        assertThatThrownBy(() -> lottoNumberParser.parse("1,2,3,4%,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 문자_예외_처리() {
        assertThatThrownBy(() -> lottoNumberParser.parse("1,2,3,ㄷ,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}