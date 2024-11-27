package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProductsTest {
    private Products products = new Products();

    @Test
    void 최소_가격_상품_반환_확인() {
        List<Product> productList = new ArrayList<>();
        Product expected = new Product("콜라", 100, 5);

        productList.add(expected);
        productList.add(new Product("사이다", 1000, 2));

        products.addAllProducts(productList);
        Product actual = products.minimumPriceProductWithoutSoldOut().get();

        assertEquals(expected, actual);
    }

    @Test
    void 최소_가격_sold_out시_그_다음_최소값_상품_반환_확인() {
        List<Product> productList = new ArrayList<>();
        Product expected = new Product("사이다", 1000, 2);

        productList.add(new Product("콜라", 100, 0));
        productList.add(expected);

        products.addAllProducts(productList);
        Product actual = products.minimumPriceProductWithoutSoldOut().get();

        assertEquals(expected, actual);
    }


}