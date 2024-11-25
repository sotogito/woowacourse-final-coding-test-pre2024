package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {


    public List<Product> parse(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        List<Product> result = new ArrayList<>();

        String[] splitProducts = input.split(";");
        Pattern pattern = Pattern.compile("\\[(.*?),(.*?),(.*?)]");

        for (String productForm : splitProducts) {
            productForm = productForm.trim();
            validateForm(productForm);

            Matcher matcher = pattern.matcher(productForm);
            if (matcher.matches()) {
                String name = matcher.group(1);
                int price = changeNumber(matcher, 2);
                int quantity = changeNumber(matcher, 3);

                result.add(new Product(name, price, quantity));
                continue;
            }
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        if (result.isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식입니다.-2");
        }
        return result;
    }

    private void validateForm(String productForm) {
        if (countContains(productForm, "[") != 1 ||
                countContains(productForm, "]") != 1 ||
                countContains(productForm, ",") != 2) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }

    private static int countContains(String orderForm, String delimiter) {
        char delimiterChar = delimiter.charAt(0);
        return (int) orderForm.chars()
                .filter(c -> c == delimiterChar)
                .count();
    }

    private int changeNumber(Matcher matcher, int index) {
        try {
            return Integer.parseInt(matcher.group(index));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("가격과 수량은 숫자로 입력해주세요");
        }
    }


}
