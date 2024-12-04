package christmas.domain.singleton;

import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    void 메뉴판_출력_확인() {
        System.out.println(Restaurant.RESTAURANT);
    }

}