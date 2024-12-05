package menu.domain.singleton;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import menu.constant.Category;
import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    void getMenusByCategory() {
        Category category = Category.KOREAN;
        List<String> actual = Restaurant.RESTAURANT.getMenusByCategory(category);
        assertTrue(actual.contains("김밥"));
    }

    @Test
    void validateMenu() {
        assertThatThrownBy(() -> Restaurant.RESTAURANT.validateMenu("마라탕"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}