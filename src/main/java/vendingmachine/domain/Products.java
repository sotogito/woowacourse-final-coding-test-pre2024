package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Products {
    private final List<Product> products;

    public Products() {
        this.products = new ArrayList<>();
    }
    
    public Product minimumPriceProduct() {
        List<Product> withoutSoldOut = new ArrayList<>();
        for (Product product : products) {
            if (!product.isSoldOut()) {
                withoutSoldOut.add(product);
            }
        }
        return Collections.min(withoutSoldOut);
    }

    public void addAllProducts(List<Product> products) {
        validateDuplicateProduct(products);
        this.products.addAll(products);
    }

    public void validateDuplicateProduct(List<Product> products) {
        Set<Product> carSet = new HashSet<>();
        for (Product product : products) {
            if (!carSet.add(product)) {
                throw new IllegalArgumentException("중복된 상품이 있어요.");
            }
        }
    }

}
