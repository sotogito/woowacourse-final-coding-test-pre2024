package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Products {
    private final List<Product> products;

    public Products() {
        this.products = new ArrayList<>();
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.isSameName(name)) {
                return product;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 상품입니다.");
    }

    public Optional<Product> minimumPriceProduct() {
        List<Product> withoutSoldOut = new ArrayList<>();
        for (Product product : products) {
            if (!product.isSoldOut()) {
                withoutSoldOut.add(product);
            }
        }
        if (withoutSoldOut.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(Collections.min(withoutSoldOut));
    }

    public boolean isAllProductSoldOut() {
        boolean isAllSoldOut = true;

        for (Product product : products) {
            if (!product.isSoldOut()) {
                isAllSoldOut = false;
                return isAllSoldOut;
            }
        }
        return isAllSoldOut;
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
