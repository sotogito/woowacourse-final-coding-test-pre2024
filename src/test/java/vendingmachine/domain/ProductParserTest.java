package vendingmachine.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProductParserTest {
    private ProductParser productParser = new ProductParser();

    @Test
    void 비어있는_입력값_예외_처리() {
        assertThatThrownBy(() -> productParser.parse(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_구분자_예외_처리() {
        assertThatThrownBy(() -> productParser.parse("[콜라,1000,1],[사이다,2000,1]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식입니다.");
    }

    @Test
    void 가격_문자_예외_처리() {
        assertThatThrownBy(() -> productParser.parse("[콜라,100ㄹ0,1];[사이다,2000,1]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("가격과 수량은 숫자로 입력해주세요");
    }

    @Test
    void 정상_생성_확인() {
        List<Product> result = productParser.parse("[콜라,1000,1];[사이다,2000,1]");
        assertEquals(2, result.size());

    }

    /**
     *  public List<Product> parse(String input) {
     *         input = input.trim();
     *         if (input.isEmpty()) {
     *             throw new IllegalArgumentException("입력값이 비어있습니다.");
     *         }
     *
     *         List<Product> result = new ArrayList<>();
     *
     *         String[] splitProducts = input.split(";");
     *         Pattern pattern = Pattern.compile("\\[(.*?),(.*?),(.*?)]");
     *
     *         for (String productForm : splitProducts) {
     *             productForm = productForm.trim();
     *             validateForm(productForm);
     *
     *             Matcher matcher = pattern.matcher(productForm);
     *             if (matcher.matches()) {
     *                 String name = matcher.group(1);
     *                 int price = changeNumber(matcher, 2);
     *                 int quantity = changeNumber(matcher, 3);
     *
     *                 result.add(new Product(name, price, quantity));
     *                 continue;
     *             }
     *             throw new IllegalArgumentException("잘못된 형식입니다.");
     *         }
     *         if (result.isEmpty()) {
     *             throw new IllegalArgumentException("잘못된 형식입니다.-2");
     *         }
     *         return result;
     *     }
     *
     *     private void validateForm(String productForm) {
     *         if (countContains(productForm, "[") != 1 ||
     *                 countContains(productForm, "]") != 1) {
     *             throw new IllegalArgumentException("괄호 이슈");
     *         } else if (countContains(productForm, ",") != 2) {
     *             throw new IllegalArgumentException("따음표");
     *         }
     *     }
     *
     *     private static int countContains(String orderForm, String delimiter) {
     *         char delimiterChar = delimiter.charAt(0);
     *         return (int) orderForm.chars()
     *                 .filter(c -> c == delimiterChar)
     *                 .count();
     *     }
     *
     *     private int changeNumber(Matcher matcher, int index) {
     *         try {
     *             return Integer.parseInt(matcher.group(index));
     *         } catch (NumberFormatException e) {
     *             throw new IllegalArgumentException("가격과 수량은 숫자로 입력해주세요");
     *         }
     *     }
     */

}